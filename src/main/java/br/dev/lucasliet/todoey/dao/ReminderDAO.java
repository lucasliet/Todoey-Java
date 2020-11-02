package br.dev.lucasliet.todoey.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.dev.lucasliet.todoey.model.Reminder;

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
		dao.add(t);
	}

	public void remove(Reminder t) {
		dao.remove(t);
	}

	public void update(Reminder t) {
		dao.update(t);
	}

	public List<Reminder> findAll() {
		return dao.findAll();
	}

	public Reminder findById(Integer id) {
		return dao.findById(id);
	}

}