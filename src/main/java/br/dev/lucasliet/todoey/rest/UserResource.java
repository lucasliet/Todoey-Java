package br.dev.lucasliet.todoey.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.dev.lucasliet.todoey.dao.UserDAO;
import br.dev.lucasliet.todoey.model.User;

@Path("/users")
@RequestScoped
public class UserResource {
	
    @Inject
    private UserDAO userDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> listAllMembers() {
        return userDAO.findAll();
    }
}
