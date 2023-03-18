package ru.rustam.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rustam.project.model.Book;
import ru.rustam.project.model.Person;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> showAll(){
       return jdbcTemplate.query("SELECT * FROM Person",
               new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersonForId(int id){
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void createPerson(Person person){
        jdbcTemplate.update("INSERT INTO Person(name, yearOfBirth) VALUES (?,?)",
                person.getName(),
                person.getYearOfBirth());
    }

    public void updatePerson(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET  name=?, yearOfBirth=? WHERE id=?",
                updatedPerson.getName(),
                updatedPerson.getYearOfBirth(),
                id);
    }

    public void deletePerson(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public Optional<Person> getPersonByName(String name){
        return jdbcTemplate.query("SELECT * FROM Person WHERE name=?", new Object[]{name},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public List<Book> getBooksByPersonId(int id){
        return jdbcTemplate.query("SELECT * FROM Books WHERE owner_id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }
}
