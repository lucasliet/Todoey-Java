package br.dev.lucasliet.todoey.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.dev.lucasliet.todoey.bean.LoginBean;
import br.dev.lucasliet.todoey.model.Reminder;
import br.dev.lucasliet.todoey.model.User;

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
		t.setUser(LoginBean.getLoggedUser());
		dao.add(t);
	}

	public void remove(Reminder t) {
		dao.remove(t);
	}

	public void update(Reminder t) {
		t.setUser(LoginBean.getLoggedUser());
		dao.update(t);
	}

	public List<Reminder> findAll() {
		return dao.findAll();
	}

	public Reminder findById(Integer id) {
		return dao.findById(id);
	}

}
