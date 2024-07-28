package br.com.bookstore.jpa.models;

import java.io.Serializable;
import java.util.UUID;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="tb_books")
public class BooKModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  @Column(nullable = false, unique = true)
  private String title;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="publisher_id")
  private PublisherModel publisher;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "tb_book_author",
    joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name="author_id")
  )
  private Set<AuthorModel> authors;

}
