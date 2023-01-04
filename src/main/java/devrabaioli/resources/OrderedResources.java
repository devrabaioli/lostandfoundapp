package devrabaioli.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devrabaioli.domain.Ordered;
import devrabaioli.services.OrderedServices;

@RestController
@RequestMapping(value = "/ordereds")
public class OrderedResources {
	
	@Autowired
	private OrderedServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Ordered obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
