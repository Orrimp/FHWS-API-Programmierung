package de.fhws.apiprog.vorlesung2.jsonexample;

import com.owlike.genson.Genson;

public class JsonExample {

	public static void main(String[] args) throws Exception {
		Genson genson = new Genson();
		Person person = new Person("James", "Bond");

		String jsonOfPerson = genson.serialize(person);
		System.out.println(jsonOfPerson);

		Person samePerson = genson.deserialize(jsonOfPerson, Person.class);
		System.out.println(person.equals(samePerson));
	}

}
