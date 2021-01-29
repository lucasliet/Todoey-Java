package dev.lucasliet.todoeyear.util;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import dev.lucasliet.todoeyear.model.User;

/**
 * A Filter that checks if the user has authorization
 * to access determined pages, if not, it will be
 * redirected to another page
 * @author Lucas Souza <lucasouliveira@gmail.com>
 */
public class AuthFilter implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private FacesContext context;
	private String pageName;

	@Override
	public void afterPhase(PhaseEvent event) {
		context = event.getFacesContext();
		
		pageName = context.getViewRoot().getViewId();
		
		User loggedUser = (User) context.getExternalContext()
				.getSessionMap().get("loggedUser");

		if (loggedUser == null) 
			checkPagesAndRedirect(JsfUtil.LOGIN_PAGE, "/login.xhtml", "/signup.xhtml");
		else
			checkPagesAndRedirect(JsfUtil.HOME_PAGE, "/new.xhtml", "/home.xhtml");	
	}
	
	/**
	 * It receives a whitelist of urls, any other will be redirected
	 * @param redirectPage page to redirect to, after checking url
	 * @param pages urls to check redirect rule
	 */
	private void checkPagesAndRedirect(String redirectPage, String... pages) {
		for(var page : pages)
			if(pageName.equals(page)) return;
		redirectTo(redirectPage);
	}
	
	/**
	 * Redirects to given page
	 * @param page
	 */
	private void redirectTo(String page) {
		var handler = context.getApplication()
				.getNavigationHandler();
		handler.handleNavigation(context, null, page);
		context.renderResponse();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
