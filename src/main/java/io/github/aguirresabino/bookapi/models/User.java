package io.github.aguirresabino.bookapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class User {

  @Id @GeneratedValue private Long id;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @PastOrPresent private LocalDate dateOfBirth;

  @NotBlank(message = "User is mandatory")
  private String user;

  @Email private String email;

  @NotBlank(message = "Password is mandatory")
  private String password;
}
