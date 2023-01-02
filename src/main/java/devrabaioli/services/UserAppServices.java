package devrabaioli.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import devrabaioli.domain.UserApp;
import devrabaioli.repositories.UserAppRepository;
import devrabaioli.services.exceptions.ObjectNotFoudException;

@Service
public class UserAppServices {
	
	@Autowired
	private UserAppRepository repo;
	
	
	public UserApp find(Integer id) {
		Optional<UserApp> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoudException("Object not found id: " + id + " Class: " + UserApp.class.getName()));
		
	}

}
