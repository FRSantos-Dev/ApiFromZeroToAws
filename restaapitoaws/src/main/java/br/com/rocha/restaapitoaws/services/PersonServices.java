package br.com.rocha.restaapitoaws.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocha.restaapitoaws.exceptions.handler.ResourceNotFoundException;
import br.com.rocha.restaapitoaws.model.Person;
import br.com.rocha.restaapitoaws.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {

		logger.info("Finding all people!");

		return repository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one person!");

		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

	public Person create(Person personVO) {

		logger.info("Creating one person!");

		return repository.save(personVO);
	}

	public Person update(Person personVO) {

		logger.info("Updating one person!");

		var entity = repository.findById(personVO.getId())
			.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());

		return repository.save(personVO);
	}

	public void delete(Long id) {

		logger.info("Deleting one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}