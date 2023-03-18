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
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> showAll(){
        return jdbcTemplate.query("SELECT * FROM books",
        new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookForId(int id){
        return jdbcTemplate.query("SELECT * FROM books WHERE id=?",
                new Object[]{id},
                new BookMapper()).stream().findAny().orElse(null);
    }

    public void createBook(Book newBook){
        jdbcTemplate.update("INSERT INTO books(title, author, year) VALUES (?, ?, ?)",
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getYear());
    }

    public void updateBook(int id, Book upBook){
        jdbcTemplate.update("UPDATE books SET author=?,year=?, title=? WHERE id=?",
                upBook.getAuthor(),
                upBook.getYear(),
                upBook.getTitle(),
                id);
    }

    public void deleteBook(int id){
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    public Optional<Person> getBookOwner(int id){
        return jdbcTemplate.query("SELECT Person.* FROM Books JOIN Person ON Books.owner_id = Person.id WHERE Books.id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public void release(int id){
        jdbcTemplate.update("UPDATE books SET owner_id=NULL WHERE id=?", id);
    }

    public void assign(int id, Person person){
        jdbcTemplate.update("UPDATE books SET owner_id=? WHERE id=?", person.getId(), id);
    }
}
