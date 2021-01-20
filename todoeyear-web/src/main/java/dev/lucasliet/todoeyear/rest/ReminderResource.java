package dev.lucasliet.todoeyear.rest;


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
    public List<Reminder> listAllReminders() {
        return reminderDAO.findAll();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reminder findReminderById(@PathParam("id") int id) {
        return returnReminderIfExists(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReminder(Reminder reminder) {
        try {
            reminderDAO.add(reminder);

            return Response.ok().build();
        } catch (Exception e) {
            return handleException(e);
        }
    }
    
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReminder(@PathParam("id") int id) {
        var reminder = returnReminderIfExists(id);
        
        reminderDAO.remove(reminder);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/(id:[0-9][0-9]*}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateReminder(@PathParam("id") int id) {
    	var reminder = returnReminderIfExists(id);
    	
    	try {
    		reminderDAO.update(reminder);
    	} catch (Exception e) {
    		return handleException(e);
    	}
    	
    	return Response.ok().entity(reminder).header("Allow", "PUT").build();
        	
    }

	private Reminder returnReminderIfExists(Integer id) {
		var reminder = reminderDAO.findById(id);
		
		if(reminder == null) throw new WebApplicationException("Reminder not found!",Response.Status.NOT_FOUND);
		
		return reminder;
	}
	
	private Response handleException(Exception e) {
		var responseObj = Map.of("error", e.getMessage().split(":")[1].trim());
        
		var builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        
		return builder.build();
	}

}
