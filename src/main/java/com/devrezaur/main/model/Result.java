package com.devrezaur.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "results")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {

  @Id
  @GeneratedValue
  private int id;
  private String username;
  private int totalCorrect;
}
