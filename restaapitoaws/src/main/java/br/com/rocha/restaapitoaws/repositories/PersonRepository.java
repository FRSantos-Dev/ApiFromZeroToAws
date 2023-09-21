package br.com.rocha.restaapitoaws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rocha.restaapitoaws.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {//coloca sempre o objeto e Id do objeto

}
