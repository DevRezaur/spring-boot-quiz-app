package com.devrezaur.main.controller;

import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.service.QuizService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final QuizService quizService;

  @GetMapping("/")
  public String home() {
    return "index.html";
  }

  @PostMapping("/quiz")
  public String quiz(Model model, RedirectAttributes redirectAttributes, @RequestParam String username) {
    if (username.isEmpty()) {
      redirectAttributes.addFlashAttribute("warning", "You must enter your name!");
      return "redirect:/";
    }

    QuestionForm questionForm = quizService.getQuestionForm();
    model.addAttribute("questionForm", questionForm);
    model.addAttribute("username", username);
    return "quiz.html";
  }

  @PostMapping("/submit")
  public String submit(Model model, @ModelAttribute QuestionForm questionForm, @RequestParam String username) {
    Result result = new Result();
    result.setUsername(username);
    result.setTotalCorrect(quizService.getResult(questionForm));

    quizService.saveResult(result);

    model.addAttribute("result", result);
    return "result.html";
  }

  @GetMapping("/score")
  public String score(Model model) {
    List<Result> scores = quizService.getResults();
    model.addAttribute("scores", scores);

    return "scoreboard.html";
  }

}
