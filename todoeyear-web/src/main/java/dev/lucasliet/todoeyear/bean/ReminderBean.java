package dev.lucasliet.todoeyear.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dev.lucasliet.todoeyear.dao.ReminderDAO;
import dev.lucasliet.todoeyear.model.Reminder;
import dev.lucasliet.todoeyear.util.ParseCalendar;

@Named
@ViewScoped
public class ReminderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Reminder reminder = new Reminder();
	
	private String deadline = "";

	private List<Reminder> reminders;

	@Inject
	ReminderDAO reminderDAO;

	@Inject
	FacesContext context;
	
	@PostConstruct
	void init() {
		if (this.reminder.getId() != null) {
			this.deadline = ParseCalendar.calendarToString(reminder.getDeadline());
		}
	}
	
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
			this.reminders = reminderDAO.findAll();
		}
		return this.reminders;
	}

	public void findById() {
		this.reminder = reminderDAO.findById(this.reminder.getId());
	}

	@Transactional
	public void save() {
		this.reminder.setDeadline(ParseCalendar.stringToCalendar(deadline));
		if (this.reminder.getId() == null) {
			reminderDAO.add(this.reminder);
			this.reminders = reminderDAO.findAll();
		} else {
			reminderDAO.update(this.reminder);
		}
		System.out.println(reminder);
		this.reminder = new Reminder();
	}

	@Transactional
	public void remove(Reminder reminder) {
		reminderDAO.remove(reminder);
		this.reminders = reminderDAO.findAll();
	}

	public void show(Reminder reminder) {
		this.reminder = this.reminderDAO.findById(reminder.getId());
	}
}
