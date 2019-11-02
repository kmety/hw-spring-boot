package ua.mate.hwspringboot.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mate.hwspringboot.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
