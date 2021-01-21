package dev.lucasliet.todoeyear.soap;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dev.lucasliet.todoeyear.dao.ReminderDAO;
import dev.lucasliet.todoeyear.model.Reminder;

@WebService
public class Remindersws {

	@Inject
	private ReminderDAO reminderDAO;

	@WebMethod(operationName = "listAllReminders")
	@WebResult(name = "reminders")
	public ListReminders getReminders() {
		return new ListReminders(reminderDAO.findAll());
	}

	@WebMethod(operationName = "listReminder")
	@WebResult(name = "reminder")
	public Reminder getReminder(@WebParam(name = "id") Integer id) {
		var reminder = reminderDAO.findById(id);
		checkIfExists(reminder);
		return reminder;
	}

	@WebMethod(operationName = "createReminder")
	public String createReminder(@WebParam(name = "reminder") Reminder reminder) {
		try {
			reminderDAO.add(reminder);
		} catch (Exception e) {
			handleException(e);
		}
		return "Created Reminder: " + reminder.getTitle();
	}
	
	@WebMethod(operationName = "deleteReminder")
	public String deleteReminder(@WebParam(name = "id") Integer id) {
		var reminder = reminderDAO.findById(id);
        checkIfExists(reminder);
        reminderDAO.remove(reminder);
        return "Reminder " + reminder.getTitle() + " deleted.";
	}
	
	@WebMethod(operationName = "updateReminder")
	public Reminder updateReminder(@WebParam(name = "reminder") Reminder reminder) {
		var checkReminder = reminderDAO.findById(reminder.getId());
    	checkIfExists(checkReminder);
    	
    	try {
    		reminderDAO.update(reminder);
    	} catch (Exception e) {
			handleException(e);
        }
    	
    	return reminder;
	}

	private void checkIfExists(Reminder reminder){
		if (reminder == null) throw new RuntimeException("Reminder not found");
	}
	
	private void handleException(Exception e) {
		throw new RuntimeException(e.getMessage().split(":")[1].trim());
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ListReminders {

	@XmlElement(name = "reminder")
	private List<Reminder> reminders;

	public ListReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	ListReminders() {
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

}