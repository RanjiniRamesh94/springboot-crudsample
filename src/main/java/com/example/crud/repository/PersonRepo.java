package com.example.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.crud.model.Person;

public interface PersonRepo extends CrudRepository<Person, Long> {

	public List<Person> findAll();
	
	public Person findByid(int id);
	

	
	
}
