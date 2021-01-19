package dev.lucasliet.todoeyear.soap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@WebResult(name = "reminders")
	public Reminder getReminder(@WebParam(name = "id") Integer id) {
		try {			
			return reminderDAO.findById(id);
		} catch (Exception e) {			
			return null;
		}
	}

	@WebMethod(operationName = "createReminder")
	public Map<String, String> createReminder(@WebParam(name = "reminder") Reminder reminder) {
		try {
			reminderDAO.add(reminder);
			return Map.of("Reminder Criado:", reminder.getTitle());
		} catch (Exception e) {
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			return responseObj;
		}
	}
	
	@WebMethod(operationName = "deleteReminder")
	public void deleteReminder(@WebParam(name = "id") Integer id) {
		var reminder = reminderDAO.findById(id);
        checkIfExists(reminder);
        reminderDAO.remove(reminder);
	}
	
	@WebMethod(operationName = "updateReminder")
	public Reminder updateReminder(@WebParam(name = "reminder") Reminder reminder) {
		var checkReminder = reminderDAO.findById(reminder.getId());
    	checkIfExists(checkReminder);
    	
    	try {
    		reminderDAO.update(reminder);
    	} catch (Exception e) {
            return null;
        }
    	
    	return reminder;
	}

	private void checkIfExists(Reminder reminder){
		if (reminder == null) throw new RuntimeException();
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ListReminders {

	@XmlElement(name = "reminders")
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