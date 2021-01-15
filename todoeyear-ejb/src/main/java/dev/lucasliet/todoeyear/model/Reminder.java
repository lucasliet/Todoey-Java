package dev.lucasliet.todoeyear.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reminders")
public class Reminder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String body;
	
	@Temporal(TemporalType.DATE)
	private Calendar lastModified = Calendar.getInstance();
	
	@Temporal(TemporalType.DATE)
	private Calendar deadline;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", nullable=false)
	private User user;

	public Reminder() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Calendar getLastModified() {
		return lastModified;
	}

	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}
	
	public Calendar getDeadline() {
		return deadline;
	}

	public void setDeadline(Calendar deadline) {
		this.deadline = deadline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getBody() {
		return body;
	}

}