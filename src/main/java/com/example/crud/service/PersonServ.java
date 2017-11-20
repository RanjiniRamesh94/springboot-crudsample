package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Person;
import com.example.crud.response.CrudResponse;

public interface PersonServ {

	
	public List<Person> getAllValues();
	
	public Person getById(int pId);
	
	public CrudResponse createPerson(Person request);

	public CrudResponse updateRequest(int personId, Person update);
	
	public CrudResponse deletePerson(int personId);
}
