package devrabaioli.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import devrabaioli.domain.Lost;
import devrabaioli.dto.LostDTO;
import devrabaioli.services.LostServices;

@RestController
@RequestMapping(value = "/losts")
public class LostResources {
	
	@Autowired
	private LostServices service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Lost> find(@PathVariable Integer id){
		Lost obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LostDTO>> findAll(){
		List<Lost> list = service.findAll();
		List<LostDTO> listDto = list.stream().map(obj -> new LostDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
