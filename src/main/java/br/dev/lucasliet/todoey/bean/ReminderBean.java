package br.dev.lucasliet.todoey.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.dev.lucasliet.todoey.dao.ReminderDAO;
import br.dev.lucasliet.todoey.model.Reminder;
import br.dev.lucasliet.todoey.model.User;

@Named
@ViewScoped
public class ReminderBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Reminder reminder = new Reminder();

	private List<Reminder> reminders;

	@Inject
	ReminderDAO reminderDAO;

	@Inject
	FacesContext context;
	
	public Reminder getReminder() {
		return reminder;
	}

	public List<Reminder> getReminders() {
		if (this.reminders == null) {
			this.reminders = reminderDAO.findAll();
		}
		return reminders;
	}

	public void findById() {
		this.reminder = reminderDAO.findById(this.reminder.getId());
	}

	@Transactional
	public void save() {
		if (this.reminder.getId() == null) {
			reminderDAO.add(this.reminder);
			this.reminders = reminderDAO.findAll();
		} else {
			reminderDAO.update(this.reminder);
		}

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
