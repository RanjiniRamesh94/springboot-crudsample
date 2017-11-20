package com.example.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepo;
import com.example.crud.response.CrudResponse;
import com.example.crud.service.PersonServImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	Person person;

	@Autowired
	PersonServImpl personServImpl;

	@Autowired
	PersonRepo personRepo;

	@Autowired
	CrudResponse response;

	// GET

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Person> getAllValues() {

		List<Person> allValues = new ArrayList<Person>();

		/*
		 * person.setId(1); person.setName("Ranju");
		 * 
		 * allValues.add(person);
		 * 
		 * person.setId(2); person.setName("Ranjini");
		 * 
		 * allValues.add(person);
		 */
		allValues = personServImpl.getAllValues();

		return allValues;

	}

	// Post

	@PostMapping(value = "/person")
	public CrudResponse savePerson(@RequestBody Person request) {

		response = personServImpl.createPerson(request);

		return response;

	}

	// PUT

	@RequestMapping(value = "/person/{id}", method = RequestMethod.PUT)
	public CrudResponse updateRequest(@PathVariable(value = "id") int personId, @RequestBody Person update) {

		response = personServImpl.updateRequest(personId, update);

		return response;

		

	}

	// Delete

	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	public CrudResponse deletePerson(@PathVariable(value = "id") int personId) {

		response = personServImpl.deletePerson(personId);

		return response;

	}

}
