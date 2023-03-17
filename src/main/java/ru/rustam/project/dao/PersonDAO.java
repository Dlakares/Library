package ru.rustam.project.dao;

import org.springframework.stereotype.Component;
import ru.rustam.project.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person("Rustam", 2002, ++PEOPLE_COUNT));
        people.add(new Person("Ruby", 2001, ++PEOPLE_COUNT));
        people.add(new Person("Somebody", 1950, ++PEOPLE_COUNT));
    }


    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatedPerson.getName());
        personToBeUpdate.setYearOfBirth(updatedPerson.getYearOfBirth());
    }
}
