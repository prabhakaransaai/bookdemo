package com.book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:4200")  
public class BookController {
	private Map<Integer, Book> books = new HashMap<>();
	

    // GET all books
    @GetMapping
    public Collection<Book> getBooks() {
    	Book b =null;
    	b = new Book();
    	b.setId(1);
    	b.setTitle("English");
    	books.put(1,b);
    	b = new Book();
    	b.setId(2);
    	b.setTitle("Tamil");
    	books.put(2,b);
    	b = new Book();
    	b.setId(3);
    	b.setTitle("Maths");
    	books.put(3,b);
        return books.values();
    }

    // POST add book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        /*Test--*/
        return book;
    }

    // DELETE book by id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        books.remove(id);
        return "Book deleted with id " + id;
    }
}
