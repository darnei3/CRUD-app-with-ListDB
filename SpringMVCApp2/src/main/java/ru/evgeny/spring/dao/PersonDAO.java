package ru.evgeny.spring.dao;

import org.springframework.stereotype.Component;
import ru.evgeny.spring.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(PEOPLE_COUNT++,"Tom", "tom@mail.ru",25));
        people.add(new Person(PEOPLE_COUNT++,"Bob", "bob@mail.ru",34));
        people.add(new Person(PEOPLE_COUNT++,"Mike", "mike@mail.ru",14));
        people.add(new Person(PEOPLE_COUNT++,"Katy", "katy@mail.ru",56));
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

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId() == id);
    }
}
