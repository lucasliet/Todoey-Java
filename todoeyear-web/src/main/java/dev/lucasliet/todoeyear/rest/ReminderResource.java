package dev.lucasliet.todoeyear.rest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.lucasliet.todoeyear.dao.ReminderDAO;
import dev.lucasliet.todoeyear.model.Reminder;

@Path("/reminders")
@RequestScoped
public class ReminderResource {
	
    @Inject
    private ReminderDAO reminderDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reminder> listAllMembers() {
        return reminderDAO.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reminder lookupMemberById(@PathParam("id") int id) {
        Reminder reminder = reminderDAO.findById(id);
        checkIfExists(reminder);
        return reminder;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReminder(Reminder reminder) {

        Response.ResponseBuilder builder = null;

        try {
            reminderDAO.add(reminder);

            builder = Response.ok();
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }
    
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReminder(@PathParam("id") int id) {
        Reminder reminder = reminderDAO.findById(id);
        checkIfExists(reminder);
        
        reminderDAO.remove(reminder);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/(id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateReminder(@PathParam("id") int id) {
    	Reminder reminder = reminderDAO.findById(id);
    	checkIfExists(reminder);
    	
    	try {
    		reminderDAO.update(reminder);
    	} catch (Exception e) {
    		Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(responseObj).build();
        }
    	return Response.ok().entity(reminder).build();
        	
    }

	private void checkIfExists(Reminder reminder) {
		if (reminder == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
	}

}
