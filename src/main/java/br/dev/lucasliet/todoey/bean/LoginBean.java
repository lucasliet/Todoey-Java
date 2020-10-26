package br.dev.lucasliet.todoey.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.dev.lucasliet.todoey.dao.UserDAO;
import br.dev.lucasliet.todoey.model.User;

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
		if (userDAO.exist(this.user)) {
			context.getExternalContext().getSessionMap()
					.put("loggedUser", this.user);
			return "todoey?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("User not found"));

		return "login?faces-redirect=true";
	}

	public String deslogar() {
		context.getExternalContext().getSessionMap().remove("loggedUser");
		return "login?faces-redirect=true";
	}
}
