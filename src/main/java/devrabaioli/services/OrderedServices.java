package devrabaioli.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devrabaioli.domain.Ordered;
import devrabaioli.repositories.OrderedRepository;
import devrabaioli.services.exceptions.ObjectNotFoudException;

@Service
public class OrderedServices {
	
	@Autowired
	private OrderedRepository repo;
	
	public Ordered find(Integer id) {
	 Optional<Ordered> obj = repo.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoudException("Object not found id: " + id + " Class: " + Ordered.class.getName()));
	}
}
