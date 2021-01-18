package dev.lucasliet.todoeyear.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dev.lucasliet.todoeyear.dao.UserDAO;
import dev.lucasliet.todoeyear.model.User;

@Named
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();
	
	private final String LOGIN_PAGE = "login?faces-redirect=true";
	private final String HOME_PAGE  = "home?faces-redirect=true";

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
			return HOME_PAGE;
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("User not found"));

		return LOGIN_PAGE;
	}
	
	@Transactional
	public String singUp() {
		this.userDAO.register(user);
		return LOGIN_PAGE;
	}

	public String logoff() {
		context.getExternalContext().getSessionMap().remove("loggedUser");
		return LOGIN_PAGE;
	}
	
}
