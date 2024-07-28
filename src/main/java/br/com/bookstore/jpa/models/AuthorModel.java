package br.com.bookstore.jpa.models;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(name="tb_authors")
public class AuthorModel implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
  private Set<BooKModel> books;
}
