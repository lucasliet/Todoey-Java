package dev.lucasliet.todoeyear.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JsfUtil {
	
	public static final String LOGIN_PAGE   = "login?faces-redirect=true";
	public static final String HOME_PAGE    = "home?faces-redirect=true";
	public static final String SIGNUP_PAGE  = "signup?faces-redirect=true";
	public static final String NEW_PAGE		= "new?faces-redirect=true";

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static void showErrorMessage(String message) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(message));
	}
	
}
