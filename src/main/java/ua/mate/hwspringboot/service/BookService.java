package ua.mate.hwspringboot.service;

import java.util.List;
import java.util.Optional;
import ua.mate.hwspringboot.dto.BookDto;
import ua.mate.hwspringboot.entity.Book;

public interface BookService {
    Book save(BookDto bookDto);

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> updateById(Long bookId, BookDto bookDto);

    void delete(Long bookId);
}
