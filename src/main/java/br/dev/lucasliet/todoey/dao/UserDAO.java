package br.dev.lucasliet.todoey.dao;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.dev.lucasliet.todoey.model.UserLogin;

@Stateless
@SuppressWarnings("serial")
public class UserDAO implements Serializable {

	@PersistenceContext
	EntityManager manager;

	public boolean exist(UserLogin user) {

		TypedQuery<UserLogin> query = manager.createQuery(
				" select u from UserLogin u "
			  + " where u.email = :pEmail and u.password = :pPassword",
				UserLogin.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pPassword", user.getPassword());
		try {
			@SuppressWarnings("unused")
			UserLogin result = query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}

		return true;
	}

}
