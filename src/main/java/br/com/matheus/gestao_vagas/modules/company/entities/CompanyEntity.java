package br.com.matheus.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  @Pattern(regexp = "\\S+", message = "the fild [username] name shouldn't have spaces")
  private String username;
  @Email(message = "The [email] fild should be a valid e-mail")
  private String email;
  @Length(min = 10, max = 100)
  private String website;
  private String description;
  @CreationTimestamp
  private LocalDateTime createdAt;
}
