package com.devrezaur.main.service;

import com.devrezaur.main.model.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class QuestionInitializer {

  private List<Question> questions;

  @PostConstruct
  public void init() {
    questions = new ArrayList<>();

    questions.add(new Question(1,
        "What is a correct syntax to output \"Hello World\" in Java?",
        "echo \"Hello World\"",
        "printf(\"Hello World\")",
        "System.out.println(\"Hello World\")",
        3, -1));

    questions.add(new Question(2,
        "Java is short for \"JavaScript.\"",
        "True",
        "False",
        "Partially True",
        2, -1));

    questions.add(new Question(3,
        "How do you insert COMMENTS in Java code?",
        "# This is a comment",
        "// This is a comment",
        "/* This is a comment",
        2, -1));

    questions.add(new Question(4,
        "Which data type is used to create a variable that should store text?",
        "String",
        "Char",
        "Both",
        1, -1));

    questions.add(new Question(5,
        "How do you create a variable with the numeric value 5?",
        "num x = 5",
        "float x = 5",
        "int x = 5",
        3, -1));

    questions.add(new Question(6,
        "How do you create a variable with the floating number 2.8?",
        "num x = 2.8",
        "float x = 2.8",
        "int x = 2.8",
        2, -1));

    questions.add(new Question(7,
        "Which method can be used to find the length of a string?",
        "getSize()",
        "length()",
        "size()",
        2, -1));

    questions.add(new Question(8,
        "Which operator is used to add together two values?",
        "&&",
        ".add()",
        "+",
        3, -1));

    questions.add(new Question(9,
        "The value of a string variable can be surrounded by single quotes.",
        "True",
        "False",
        "Maybe",
        2, -1));

    questions.add(new Question(10,
        "Which operator can be used to compare two values?",
        "><",
        "&|",
        "==",
        3, -1));
  }

}

