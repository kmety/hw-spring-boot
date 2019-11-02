package ua.mate.hwspringboot.dto;

import ua.mate.hwspringboot.entity.Book;

public class BookDtoUtil {
    public static Book getBookFromDto(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setYear(bookDto.getYear());
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
