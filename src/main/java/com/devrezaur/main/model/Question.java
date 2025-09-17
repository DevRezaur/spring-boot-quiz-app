package com.devrezaur.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Question {

  private int quesId;
  private String title;
  private String optionA;
  private String optionB;
  private String optionC;
  private int ans;
  private int chose;

}
