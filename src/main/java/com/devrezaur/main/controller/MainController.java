package com.devrezaur.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.devrezaur.main.model.Question;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.repository.QuestionRepo;
import com.devrezaur.main.service.ResultService;

@Controller
public class MainController {
	
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	ResultService rs;
	
	@ModelAttribute("username")
	public String setUsername(String username) {
		return username;
	}
	
	@GetMapping({"/", "/quiz"})
	public String home() {
		return "index.html";
	}
	
	@PostMapping("/quiz")
	public String quiz(@RequestParam String username, Model m, RedirectAttributes ra) {
		if(username.equals("")) {
			ra.addFlashAttribute("warning", "You must enter your name");
			return "redirect:/";
		}
		
		QuestionForm qForm = new QuestionForm();
		List<Question> qList = qRepo.findAll();
		qForm.setQuestions(qList);
		
		m.addAttribute("qForm", qForm);
		return "quiz.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m, RedirectAttributes ra) {
		Result result = rs.getResult(qForm);
		//m.addAttribute("result", result);
		ra.addFlashAttribute("result", result);
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String submit_() {	
		return "result.html";
	}
}
