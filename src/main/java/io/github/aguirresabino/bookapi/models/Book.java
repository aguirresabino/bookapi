package io.github.aguirresabino.bookapi.models;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Book {

  @Id @GeneratedValue private Long id;

  @NotBlank(message = "Title is mandatory")
  private String title;

  private String subtitle;

  @NotNull(message = "Publication date is mandatory")
  private ZonedDateTime published;

  private String publisher;

  @NotNull(message = "Number of pages is mandatory")
  private Integer pageCount;

  @ElementCollection
  @CollectionTable(name = "authors")
  @NotEmpty
  private List<String> author;

  @URL private String thumbnailUrl;

  @Column(columnDefinition = "TEXT")
  private String shortDescription;

  @Column(unique = true)
  @NotBlank
  private String isbn;
}
