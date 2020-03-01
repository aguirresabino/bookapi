package io.github.aguirresabino.bookapi.services;

import io.github.aguirresabino.bookapi.models.Book;
import io.github.aguirresabino.bookapi.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BookService {

  private final BookRepository bookRepository;

  public Book save(Book book) {
    return this.bookRepository.save(book);
  }

  @Transactional(readOnly = true)
  public Optional<Book> findById(Long id) {
    return this.bookRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Book> findAll() {
    return this.bookRepository.findAll();
  }

  public Book update(Long id, Book book) {
    book.setId(id);
    return this.bookRepository.save(book);
  }

  public void deleteById(Long id) {
    this.bookRepository.deleteById(id);
  }

  public void delete(Book book) {
    this.bookRepository.delete(book);
  }

  public void deleteAll(List<Book> books) {
    this.bookRepository.deleteAll(books);
  }
}
