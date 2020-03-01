package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {

  @Id @GeneratedValue private Long id;

  @Column(unique = true)
  @NotBlank
  private String isbn;

  @NotBlank private String title;
  @NotBlank private String author;
}
