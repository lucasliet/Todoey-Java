package dev.lucasliet.todoeyear.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dev.lucasliet.todoeyear.dao.ReminderDAO;
import dev.lucasliet.todoeyear.model.Reminder;
import dev.lucasliet.todoeyear.util.JsfUtil;
import dev.lucasliet.todoeyear.util.ParseCalendar;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ReminderBean implements Serializable {

	private Reminder reminder = new Reminder();
	
	private String deadline = "";

	private List<Reminder> reminders;

	@Inject
	ReminderDAO reminderDAO;

	@Inject
	FacesContext context;
	
	public String getDeadline() {
		return this.deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public Reminder getReminder() {
		return this.reminder;
	}

	public List<Reminder> getReminders() {
		if (this.reminders == null) {
			this.reminders = reminderDAO.findAllFromLoggedUser();
		}
		return this.reminders;
	}

	public void findById() {
		this.reminder = reminderDAO.findById(this.reminder.getId());
		if(this.reminder.getDeadline() != null)
			this.deadline = ParseCalendar.calendarToString(reminder.getDeadline());
	}

	@Transactional
	public String save() {
		try {
			reminder.setDeadline(ParseCalendar.stringToCalendar(deadline));
		} catch (ParseException e) {
			JsfUtil.showErrorMessage("Invalid Date Format! use dd/mm/yyyy pattern");
			return JsfUtil.NEW_PAGE;
		}
		
		if (reminder.getId() == null) {
			reminderDAO.add(reminder);
			reminders = reminderDAO.findAllFromLoggedUser();
		} else {
			reminderDAO.update(reminder);
		}
		reminder = new Reminder();
		return JsfUtil.HOME_PAGE;
	}

	@Transactional
	public String remove(Reminder reminder) {
		reminderDAO.remove(reminder);
		this.reminders = reminderDAO.findAllFromLoggedUser();
		return JsfUtil.HOME_PAGE;
	}

	public String edit(Reminder reminder) {
		return JsfUtil.NEW_PAGE + "&reminderId=" + reminder.getId();
	}
}
