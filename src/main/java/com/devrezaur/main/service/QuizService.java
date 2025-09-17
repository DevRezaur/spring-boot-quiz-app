package com.devrezaur.main.service;

import com.devrezaur.main.model.Question;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {

  private List<Question> allQuestions;
  private List<Result> allResults;

  private final QuestionInitializer questionInitializer;

  @PostConstruct
  private void init() {
    allQuestions = questionInitializer.getQuestions();
    allResults = new ArrayList<>();
  }

  public QuestionForm getQuestionForm() {
    List<Question> selectedQuestions = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 5; i++) {
      int randomNumber = random.nextInt(allQuestions.size());
      selectedQuestions.add(allQuestions.get(randomNumber));
      allQuestions.remove(randomNumber);
    }

    return new QuestionForm(selectedQuestions);
  }

  public int getResult(QuestionForm questionForm) {
    int correct = 0;

    for (Question question : questionForm.getQuestions()) {
      if (question.getAns() == question.getChose()) {
        correct++;
      }
    }

    return correct;
  }

  public void saveResult(Result result) {
    allResults.add(result);
  }

  public List<Result> getResults() {
    allResults.sort((r1, r2) -> Integer.compare(r2.getTotalCorrect(), r1.getTotalCorrect()));
    return allResults;
  }
}
