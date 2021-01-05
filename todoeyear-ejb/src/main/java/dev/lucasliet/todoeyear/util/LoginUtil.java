package dev.lucasliet.todoeyear.util;

import javax.faces.context.FacesContext;

import dev.lucasliet.todoeyear.model.User;

public class LoginUtil {
	public static User getLoggedUser() {
		return (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loggedUser");
	}
}
