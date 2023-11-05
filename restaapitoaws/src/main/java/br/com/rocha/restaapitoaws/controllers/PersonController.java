package br.com.rocha.restaapitoaws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.rocha.restaapitoaws.model.Person;
import br.com.rocha.restaapitoaws.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;
	///private br.com.rocha.exceptionhandling.services.PersonServices service = new br.com.rocha.exceptionhandling.services.PersonServices();
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person personVO) {
		return service.create(personVO);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person personVO) {
		return service.update(personVO);
	}


	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}