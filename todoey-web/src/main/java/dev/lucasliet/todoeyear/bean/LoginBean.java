package dev.lucasliet.todoeyear.bean;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dev.lucasliet.todoeyear.dao.UserDAO;
import dev.lucasliet.todoeyear.model.User;
import dev.lucasliet.todoeyear.util.JsfUtil;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class LoginBean implements Serializable {

	private User user = new User();

	@Inject
	UserDAO userDAO;

	@Inject
	FacesContext context;
	
	public User getUser() {
		return user;
	}

	public String login() {
		user = userDAO.retrieveUser(user);
		if (this.user != null) {
			context.getExternalContext().getSessionMap()
					.put("loggedUser", user);
			return JsfUtil.HOME_PAGE;
		}

		JsfUtil.showErrorMessage("User not Found");

		return JsfUtil.LOGIN_PAGE;
	}
	
	@Transactional
	public String singUp() {
		try {			
			userDAO.register(user);
		} catch(Exception ex) {
			JsfUtil.showErrorMessage("This User e-mail already exists");
			return JsfUtil.SIGNUP_PAGE;
		}
		
		return JsfUtil.LOGIN_PAGE;
	}

	public String logoff() {
		context.getExternalContext().getSessionMap().remove("loggedUser");
		return JsfUtil.LOGIN_PAGE;
	}

	public void deleteTestUsers() {
		userDAO.deleteTestUsers();
	}
	
}
