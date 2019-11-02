package ua.mate.hwspringboot.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.mate.hwspringboot.dto.BookDto;
import ua.mate.hwspringboot.service.BookService;

@Component
public class DataInitializer {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void initData() {
        saveBooks();
    }

    private void saveBooks() {
        BookDto kobzar = new BookDto("Kobzar", 100., 2019);
        kobzar.setDescription("This book is awesome");
        bookService.save(kobzar);
        BookDto kobzar1 = new BookDto("Kobzar", 85., 2018);
        bookService.save(kobzar1);
        BookDto lysovaMavka = new BookDto("Lysova Mavka", 131.50, 2016);
        bookService.save(lysovaMavka);
        BookDto lysovaPisnya = new BookDto("Lysova Pisnya", 42., 2017);
        bookService.save(lysovaPisnya);
        BookDto kamenyary = new BookDto("Kamenyary", 99., 2018);
        bookService.save(kamenyary);
        BookDto kemenyaryGold = new BookDto("Kamenyary. Gold Edition", 249., 2017);
        bookService.save(kemenyaryGold);
    }
}
