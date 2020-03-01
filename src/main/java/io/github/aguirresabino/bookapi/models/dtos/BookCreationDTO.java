package io.github.aguirresabino.bookapi.models.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookCreationDTO {
  @NotBlank private String isbn;
  @NotBlank private String title;
  @NotBlank private String author;
}
