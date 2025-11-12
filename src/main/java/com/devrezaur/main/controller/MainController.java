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
  public String homePage() {
    return "home-page.html";
  }

  @PostMapping("/quiz")
  public String quizPage(@RequestParam String username, Model model, RedirectAttributes redirectAttributes) {
    if (username.isEmpty()) {
      redirectAttributes.addFlashAttribute("warning", "Please enter your name");
      return "redirect:/";
    }

    QuestionForm questionForm = quizService.getQuestions();
    model.addAttribute("questionForm", questionForm);
    model.addAttribute("username", username);

    return "quiz-page.html";
  }

  @PostMapping("/submit")
  public String resultPage(@RequestParam String username, @ModelAttribute QuestionForm questionForm, Model model) {
    Result result = quizService.evaluateAndSaveResult(username, questionForm);
    model.addAttribute("result", result);

    return "result-page.html";
  }

  @GetMapping("/scoreboard")
  public String scoreboardPage(Model model) {
    List<Result> results = quizService.getResults();
    model.addAttribute("results", results);

    return "scoreboard-page.html";
  }

}
