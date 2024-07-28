package br.com.bookstore.jpa.models;

import java.io.Serializable;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="tb_publishers")
public class PublisherModel implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name;
  // Fetch Type Lazy - Busca os elementos sobre demanda.
  // Fetch Type Eager - Carrega as subconsultas de uma vez.

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
  private Set<BooKModel> books;


}
