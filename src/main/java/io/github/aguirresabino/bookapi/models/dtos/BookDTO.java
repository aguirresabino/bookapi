package io.github.aguirresabino.bookapi.models.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BookDTO {

  @NotNull private Long id;
  @NotBlank private String isbn;
  @NotBlank private String title;
  @NotBlank private String author;
}
