package io.github.aguirresabino.bookapi.models;

import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "Title is mandatory")
  private String title;

  private String subtitle;

  @NotNull(message = "Publication date is mandatory")
  private LocalDateTime published;

  private String publisher;

  @NotNull(message = "Number of pages is mandatory")
  private Integer pagesNumber;

  @ElementCollection @NotEmpty private List<String> authors;

  @URL private String thumbnailUrl;

  @Column(columnDefinition = "TEXT")
  private String shortDescription;

  @Column(unique = true)
  @NotBlank
  private String isbn;
}
