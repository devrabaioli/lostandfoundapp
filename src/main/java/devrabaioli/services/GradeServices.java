package devrabaioli.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import devrabaioli.domain.Grade;
import devrabaioli.repositories.GradeRepository;
import devrabaioli.services.exceptions.DataIntegrityException;
import devrabaioli.services.exceptions.ObjectNotFoudException;

@Service
public class GradeServices {
	
	@Autowired
	private GradeRepository repo;
	
	public Grade find(Integer id) {
	 Optional<Grade> obj = repo.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoudException("Object not found id: " + id + " Class: " + Grade.class.getName()));
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Operation not possible!");
		}
	}
}
