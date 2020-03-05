package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @PastOrPresent private LocalDate dateOfBirth;

  @NotBlank(message = "User is mandatory")
  private String username;

  @Email private String email;

  @NotBlank(message = "Password is mandatory")
  private String password;
}
