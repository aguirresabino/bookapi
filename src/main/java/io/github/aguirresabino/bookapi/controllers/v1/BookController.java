package io.github.aguirresabino.bookapi.controllers.v1;

import io.github.aguirresabino.bookapi.models.Book;
import io.github.aguirresabino.bookapi.models.dtos.BookCreationDTO;
import io.github.aguirresabino.bookapi.models.dtos.BookDTO;
import io.github.aguirresabino.bookapi.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(
    value = "Book management",
    tags = "Book management",
    produces = "application/json",
    consumes = "application/json")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("v1/books")
public class BookController {

  private static final ModelMapper modelMapper = new ModelMapper();
  private final BookService bookService;

  @ApiOperation("Create book")
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @SneakyThrows
  public BookDTO save(@Valid @RequestBody BookCreationDTO bookDTO) {
    final Book book = modelMapper.map(bookDTO, Book.class);
    final Book bookCreated = this.bookService.save(book);

    return modelMapper.map(bookCreated, BookDTO.class);
  }

  @ApiOperation("Find book by ID")
  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> findById(
      @ApiParam(value = "Unique book identification", required = true, example = "1") @PathVariable
          Long id) {
    Optional<Book> book = this.bookService.findById(id);
    return book.map(value -> ResponseEntity.ok(modelMapper.map(value, BookDTO.class)))
        .orElse(ResponseEntity.notFound().build());
  }

  @ApiOperation("List books")
  @GetMapping
  public List<BookDTO> findAll() {
    List<Book> books = this.bookService.findAll();
    return books
        .parallelStream()
        .map(book -> modelMapper.map(book, BookDTO.class))
        .collect(Collectors.toList());
  }

  @ApiOperation("Update book")
  @SneakyThrows
  @PutMapping("/{id}")
  public ResponseEntity<BookDTO> update(
      @ApiParam(value = "Unique book identification", required = true, example = "1") @PathVariable
          Long id,
      @Valid @RequestBody BookCreationDTO bookCreationDTO) {

    Book bookToUpdate = modelMapper.map(bookCreationDTO, Book.class);
    Optional<Book> bookUpdated = this.bookService.update(id, bookToUpdate);

    return bookUpdated
        .map(book -> ResponseEntity.ok(modelMapper.map(book, BookDTO.class)))
        .orElse(ResponseEntity.notFound().build());
  }

  @ApiOperation("Remove book by ID")
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteById(
      @ApiParam(value = "Unique book identification", required = true, example = "1") @PathVariable
          Long id) {
    Optional<Book> book = this.bookService.findById(id);
    book.ifPresent(this.bookService::delete);
  }
}
