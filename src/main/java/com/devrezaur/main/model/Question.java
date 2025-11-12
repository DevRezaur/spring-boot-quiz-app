package com.devrezaur.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "questions")
public class Question {

  @Id
  @GeneratedValue
  private int quesId;
  private String title;
  private String optionA;
  private String optionB;
  private String optionC;
  private int ans;
  private int chose;

}
