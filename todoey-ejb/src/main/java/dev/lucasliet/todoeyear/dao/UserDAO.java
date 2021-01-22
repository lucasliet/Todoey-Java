package dev.lucasliet.todoeyear.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

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
	
	/**
	 * Find user by e-mail and password
	 * @param user with only e-mail and password
	 * @return user fully from db
	 */
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
	
	public void register(User user) throws ConstraintViolationException{
		dao.add(user);
	}
	
	public List<User> findAll(){
		return dao.findAll();
	}
	
	public User findById(Integer id) {
		return dao.findById(id);
	}
	
	public void deleteTestUsers() {
		manager.createQuery(
				" delete from User u " +
			    " where u.email = 'usuario%@test.com",
				User.class)
			   .executeUpdate();
	}

}
