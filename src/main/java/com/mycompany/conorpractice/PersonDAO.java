/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conorpractice;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author conorprunty
 */
public enum PersonDAO {
    instance;

	private Map<String, Person> persons = new HashMap<>();

	private PersonDAO() {

		//pumping-in some default data
		Person person = new Person("1", "Conor", "Dublin");
		persons.put("1", person);
		person = new Person("2", "Joe", "Berlin");
		persons.put("2", person);

	}

	public Map<String, Person> getPersons() {
		return persons;
	}

}
