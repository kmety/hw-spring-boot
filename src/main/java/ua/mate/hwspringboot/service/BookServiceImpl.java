package ua.mate.hwspringboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mate.hwspringboot.dto.BookDto;
import ua.mate.hwspringboot.dto.BookDtoUtil;
import ua.mate.hwspringboot.entity.Book;
import ua.mate.hwspringboot.repositiry.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(BookDto bookDto) {
        Book book = BookDtoUtil.getBookFromDto(bookDto);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> updateById(Long bookId, BookDto bookDto) {
        if (bookRepository.existsById(bookId)) {
            Book book = BookDtoUtil.getBookFromDto(bookDto);
            book.setId(bookId);
            bookRepository.save(book);
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
