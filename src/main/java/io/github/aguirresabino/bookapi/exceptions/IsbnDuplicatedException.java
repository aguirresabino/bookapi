package io.github.aguirresabino.bookapi.exceptions;

public class IsbnDuplicated extends Exception {

  public IsbnDuplicated(String message) {
    super(message);
  }

  public IsbnDuplicated() {
    super("ISBN already exists");
  }
}
