package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CollectionBook {

  @Id @GeneratedValue private Long id;
  @ManyToMany private List<Book> books;
  @ManyToOne @NotNull private User user;

  @NotBlank(message = "Title is mandatory")
  private String title;
}
