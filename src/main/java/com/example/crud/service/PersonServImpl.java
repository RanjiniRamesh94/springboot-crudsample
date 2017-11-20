package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.model.Person;
import com.example.crud.repository.PersonRepo;
import com.example.crud.response.CrudResponse;

public class PersonServImpl implements PersonServ {

	@Autowired
	Person person;

	@Autowired
	PersonRepo personRepo;

	@Autowired
	CrudResponse response;

	@Override
	public List<Person> getAllValues() {

		List<Person> allValues = new ArrayList<Person>();

		allValues = personRepo.findAll();

		return allValues;
	}

	@Override
	public Person getById(int pId) {

		person = personRepo.findOne((long) pId);
		return person;
	}

	public CrudResponse createPerson(Person request) {

		try {

			personRepo.save(request);

			response.setMessage("Created Successfully");

		}

		catch (Exception e) {

			response.setMessage("Creation Falied " + e.getMessage());
		}

		return response;
	}

	public CrudResponse updateRequest(int personId, Person update) {

		
		person = personRepo.findByid(personId);

		if (null == person) {

			response.setMessage("Person ID not found in DB");

		}

		else {

			try {
				person.setName(update.getName());
				response.setMessage("Resource updated Successfully");
			}
		
			catch(Exception e) {
				
				response.setMessage("Updation Falied");
				
			}

		}

		return response;
	}

	public CrudResponse deletePerson(int personId) {
		
		person = personRepo.findByid(personId);

		if (null == person) {

			response.setMessage("Person ID not found in DB");

		}

		else {

			try {
			personRepo.delete(person);
			}
		
			catch(Exception e) {
				
				response.setMessage("Deletion Falied");
				
			}

		}

		return response;
	}

	
	
	
}
