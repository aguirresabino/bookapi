package io.github.aguirresabino.bookapi.exceptions;

public class IsbnDuplicatedException extends Exception {

  public IsbnDuplicatedException(String message) {
    super(message);
  }

  public IsbnDuplicatedException() {
    super("ISBN already exists");
  }
}
