package todo.crudtest.soap;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import todo.crudtest.data.ReminderRepository;
import todo.crudtest.model.Reminder;

@Stateless
@WebService
public class MemberResourceSOAPService {
	
	@Inject
	private ReminderRepository repository;
	
	@WebMethod
	public List<Reminder> listAllMembers() {
		return repository.findAllOrderedByName();
	}

}
