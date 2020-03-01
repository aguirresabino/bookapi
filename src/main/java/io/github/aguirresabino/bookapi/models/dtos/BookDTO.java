package io.github.aguirresabino.bookapi.models.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookDTO {

  @NotNull private Long id;
  @NotBlank private String isbn;
  @NotBlank private String title;
  @NotBlank private String author;
}
