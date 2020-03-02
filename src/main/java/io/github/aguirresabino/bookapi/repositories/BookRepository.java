package io.github.aguirresabino.bookapi.repositories;

import io.github.aguirresabino.bookapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);
}
