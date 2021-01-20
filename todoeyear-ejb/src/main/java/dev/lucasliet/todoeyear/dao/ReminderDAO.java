package dev.lucasliet.todoeyear.dao;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dev.lucasliet.todoeyear.model.Reminder;
import dev.lucasliet.todoeyear.util.LoginUtil;

@Stateless
@SuppressWarnings("serial")
public class ReminderDAO implements Serializable {

	@PersistenceContext
	EntityManager manager;

	private GenericDAO<Reminder> dao;
	
	@Inject
	private UserDAO userDAO;
	
	@PostConstruct
	void init() {
		this.dao = new GenericDAO<Reminder>(this.manager, Reminder.class);
	}

	public void add(Reminder t) {
		if (t.getUser() == null)
			t.setUser(LoginUtil.getLoggedUser());
		else
			t.setUser(userDAO.findById(t.getUser().getId()));
		if(t.getUser() == null) throw new NoResultException("User not Found");
		dao.add(t);
	}

	public void remove(Reminder t) {
		dao.remove(t);
	}

	public void update(Reminder t) {
		if (t.getUser() == null)
			t.setUser(LoginUtil.getLoggedUser());
		else
			t.setUser(userDAO.findById(t.getUser().getId()));
		dao.update(t);
	}

	public List<Reminder> findAllFromLoggedUser() {
		List<Reminder> sortedList = dao.findAll("user", LoginUtil.getLoggedUser()).stream()
				.sorted((reminder1, reminder2) -> reminder1.getId().compareTo(reminder2.getId()))
				.collect(Collectors.toList());
		return sortedList;
	}
	
	public List<Reminder> findAll(){
		List<Reminder> sortedList = dao.findAll().stream()
				.sorted((reminder1, reminder2) -> reminder1.getId().compareTo(reminder2.getId()))
				.collect(Collectors.toList());
		return sortedList;
	}

	public Reminder findById(Integer id) {
		return dao.findById(id);
	}

}
