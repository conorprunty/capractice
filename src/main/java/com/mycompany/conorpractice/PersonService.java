/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conorpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author conorprunty
 */
public class PersonService {
    PersonDAO personDAO;

	public PersonService() {
		personDAO = PersonDAO.instance;
	}

	public void createPerson(Person person) {
		personDAO.getPersons().put(person.getId(), person);
	}

	public Person getPerson(String id) {
		return personDAO.getPersons().get(id);
	}

	public Map<String, Person> getPersons() {
		return personDAO.getPersons();
	}

	public List<Person> getPersonAsList() {
		List<Person> personList = new ArrayList<>();
		personList.addAll(personDAO.getPersons().values());
		return personList;
	}

	public int getPersonsCount() {
		return personDAO.getPersons().size();
	}

	public void deletePerson(String id) {
		personDAO.getPersons().remove(id);
	}

}
