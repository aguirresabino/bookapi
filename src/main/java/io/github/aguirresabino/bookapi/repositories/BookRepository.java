package io.github.aguirresabino.bookapi.repositories;

import io.github.aguirresabino.bookapi.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
