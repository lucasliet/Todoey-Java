package dev.lucasliet.todoeyear.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.lucasliet.todoeyear.model.Reminder;
import dev.lucasliet.todoeyear.util.LoginUtil;

@Stateless
@SuppressWarnings("serial")
public class ReminderDAO implements Serializable {

	@PersistenceContext
	EntityManager manager;

	private GenericDAO<Reminder> dao;
	
	@PostConstruct
	void init() {
		this.dao = new GenericDAO<Reminder>(this.manager, Reminder.class);
	}

	public void add(Reminder t) {
		t.setUser(LoginUtil.getLoggedUser());
		dao.add(t);
	}

	public void remove(Reminder t) {
		dao.remove(t);
	}

	public void update(Reminder t) {
		t.setUser(LoginUtil.getLoggedUser());
		dao.update(t);
	}

	public List<Reminder> findAll() {
		return dao.findAll();
	}

	public Reminder findById(Integer id) {
		return dao.findById(id);
	}

}
