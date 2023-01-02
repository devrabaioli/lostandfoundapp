package devrabaioli.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import devrabaioli.domain.Grade;
import devrabaioli.services.GradeServices;

@RestController
@RequestMapping(value = "/grades")
public class GradeResources {
	
	@Autowired
	private GradeServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Grade obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
