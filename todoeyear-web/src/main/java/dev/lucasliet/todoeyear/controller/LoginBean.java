package dev.lucasliet.todoeyear.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dev.lucasliet.todoeyear.dao.UserDAO;
import dev.lucasliet.todoeyear.model.User;

@Named
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Inject
	UserDAO userDAO;

	@Inject
	FacesContext context;
	
	public User getUser() {
		return user;
	}

	public String login() {
		this.user = userDAO.retrieveUser(this.user);
		if (this.user != null) {
			context.getExternalContext().getSessionMap()
					.put("loggedUser", this.user);
			return "home?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("User not found"));

		return "login?faces-redirect=true";
	}

	public String logoff() {
		context.getExternalContext().getSessionMap().remove("loggedUser");
		return "login?faces-redirect=true";
	}
	
}
