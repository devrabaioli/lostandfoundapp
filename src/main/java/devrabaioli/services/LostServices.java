package devrabaioli.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devrabaioli.domain.Lost;
import devrabaioli.repositories.LostRepository;
import devrabaioli.services.exceptions.ObjectNotFoudException;

@Service
public class LostServices {
	
	@Autowired
	private LostRepository repo;
	
	public Lost find(Integer id) {
	 Optional<Lost> obj = repo.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoudException("Object not found id: " + id + " Class: " + Lost.class.getName()));
	}
	
	public List<Lost> findAll(){
		return repo.findAll();
	}
}
