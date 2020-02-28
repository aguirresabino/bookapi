package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
  private String isbn;

  private String title;
  private String author;
}
