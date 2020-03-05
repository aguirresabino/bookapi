package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "collection")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CollectionBook {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToMany private List<Book> books;
  @ManyToOne @NotNull private Person person;

  @NotBlank(message = "Title is mandatory")
  private String title;
}
