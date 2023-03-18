package ru.rustam.project.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.rustam.project.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setName(rs.getString("name"));
        person.setYearOfBirth(rs.getInt("year"));

        return person;
    }
}
