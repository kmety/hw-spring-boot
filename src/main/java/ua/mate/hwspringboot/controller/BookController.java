package ua.mate.hwspringboot.controller;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mate.hwspringboot.dto.BookDto;
import ua.mate.hwspringboot.entity.Book;
import ua.mate.hwspringboot.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{bookId}")
    public Book getById(@PathVariable("bookId") Long bookId) {
        return bookService.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id " + bookId));
    }

    @PostMapping
    public void add(@Valid @RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable("bookId") Long bookId) {
        bookService.delete(bookId);
    }

    @PutMapping("/{bookId}")
    public Book update(@PathVariable("bookId") Long bookId, @Valid @RequestBody BookDto bookDto) {
        Optional<Book> bookOptional = bookService.updateById(bookId, bookDto);
        return bookOptional.orElseThrow(
                () -> new EntityNotFoundException("Can't update book by id " + bookId));
    }
}
