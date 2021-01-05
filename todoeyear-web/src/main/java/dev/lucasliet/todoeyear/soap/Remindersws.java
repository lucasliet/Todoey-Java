package dev.lucasliet.todoeyear.soap;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
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
	private ReminderDAO reminderDao;
	
	@WebMethod(operationName = "listAllReminders")
	@WebResult(name = "reminders")
	public ListReminders getReminders(){
		return new ListReminders(reminderDao.findAll());
	}
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ListReminders{
	
	@XmlElement(name = "reminder")
	private List<Reminder> reminders;
	
	public ListReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	
	ListReminders(){}

	public List<Reminder> getReminders() {
		return reminders;
	}

}