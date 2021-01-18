package dev.lucasliet.todoeyear.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.lucasliet.todoeyear.model.User;

@Stateless
@SuppressWarnings("serial")
public class UserDAO implements Serializable {

	@PersistenceContext
	EntityManager manager;
	
	private GenericDAO<User> dao;
	
	@PostConstruct
	void init() {
		this.dao = new GenericDAO<User>(this.manager, User.class);
	}

	public User retrieveUser(User user) {
		TypedQuery<User> query = manager.createQuery(
				" select u from User u "
			  + " where u.email = :pEmail and u.password = :pPassword",
				User.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pPassword", user.getPassword());
		try {
			return query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
	}
	
	public void register(User user) {
		this.dao.add(user);
	}
	
	public List<User> findAll(){
		return dao.findAll();
	}

}
