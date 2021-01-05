package dev.lucasliet.todoeyear.controller;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.lucasliet.todoeyear.model.Reminder;
import dev.lucasliet.todoeyear.model.User;

@Stateless
@Named
@SuppressWarnings("serial")
public class PopulaBanco implements Serializable {
	
	@PersistenceContext
	EntityManager em;

	public void init() {
		User user = generateUser();
		em.persist(user);
		
		Reminder reminder = generateReminder(user);
		em.persist(reminder);
	}

	private static Reminder generateReminder(User user) {
		Reminder reminder = new Reminder();
		reminder.setTitle("First Reminder");
		reminder.setBody("Test");
		reminder.setUser(user);
		return reminder;
	}

	private static User generateUser() {
		User user = new User();
		user.setEmail("lucasliet@test.com");
		user.setPassword("123");
		return user;
	}

	@SuppressWarnings("unused")
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