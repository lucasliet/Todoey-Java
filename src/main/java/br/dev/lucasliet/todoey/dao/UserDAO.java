package br.dev.lucasliet.todoey.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.dev.lucasliet.todoey.model.User;

@Stateless
@SuppressWarnings("serial")
public class UserDAO implements Serializable {

	@PersistenceContext
	EntityManager manager;

	public boolean exist(User user) {

		TypedQuery<User> query = manager.createQuery(
				" select u from User u "
			  + " where u.email = :pEmail and u.password = :pPassword",
				User.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pPassword", user.getPassword());
		try {
			@SuppressWarnings("unused")
			User result = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		return true;
	}

}
