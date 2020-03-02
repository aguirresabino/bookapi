package io.github.aguirresabino.bookapi.handlers;

import io.github.aguirresabino.bookapi.apierror.ApiError;
import io.github.aguirresabino.bookapi.exceptions.IsbnDuplicatedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
    return this.buildResponseEntity(
        new ApiError(ex.getMessage(), ex, HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now()));
  }

  @ExceptionHandler(IsbnDuplicatedException.class)
  protected ResponseEntity<Object> handleIsbnDuplicated(IsbnDuplicatedException ex) {
    return this.buildResponseEntity(
        new ApiError(ex.getMessage(), ex, HttpStatus.BAD_REQUEST, ZonedDateTime.now()));
  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    log.debug("Exception: ", apiError.getThrowable());
    return new ResponseEntity<>(apiError, apiError.getHttpStatus());
  }
}
