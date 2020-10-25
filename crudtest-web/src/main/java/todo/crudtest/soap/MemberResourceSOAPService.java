package todo.crudtest.soap;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import todo.crudtest.data.MemberRepository;
import todo.crudtest.model.Member;

@Stateless
@WebService
public class MemberResourceSOAPService {
	
	@Inject
	private MemberRepository repository;
	
	@WebMethod
	public List<Member> listAllMembers() {
		return repository.findAllOrderedByName();
	}

}
