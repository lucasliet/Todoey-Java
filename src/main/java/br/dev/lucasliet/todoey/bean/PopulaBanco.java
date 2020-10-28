package br.dev.lucasliet.todoey.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.dev.lucasliet.todoey.model.Reminder;
import br.dev.lucasliet.todoey.model.UserLogin;

@Stateless
@Named
@SuppressWarnings("serial")
public class PopulaBanco implements Serializable {
	
	@PersistenceContext
	EntityManager em;

	public void init() {
		UserLogin user = generateUser();
		em.persist(user);
		
		Reminder reminder = generateReminder(user);
		em.persist(reminder);
	}

	private static Reminder generateReminder(UserLogin user) {
		Reminder reminder = new Reminder();
		reminder.setTitle("First Reminder");
		reminder.setBody("Test for the first reminder body");
		reminder.setUser(user);
		return reminder;
	}

	private static UserLogin generateUser() {
		UserLogin user = new UserLogin();
		user.setEmail("lucasliet@test.com");
		user.setPassword("123");
		return user;
	}

	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
;