package com.devrezaur.main.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.Question;
import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.repository.QuestionRepo;

@Service
public class QuizService {
	
	@Autowired
	Question question;
	@Autowired
	QuestionForm qForm;
	@Autowired
	QuestionRepo qRepo;
	@Autowired
	Result result;
	
	public QuestionForm getQuestions() {
		List<Question> allQues = qRepo.findAll();
		List<Question> qList = new ArrayList<Question>();
		
		Random random = new Random();
		
		for(int i=0; i<4; i++) {
			int rand = random.nextInt(allQues.size());
			qList.add(allQues.get(rand));
			allQues.remove(rand);
		}

		qForm.setQuestions(qList);
		
		return qForm;
	}
	
	public Result getResult(QuestionForm qForm) {
		result.setTotalCorrect(0);
		result.setTotalWrong(0);
		
		for(Question q: qForm.getQuestions()) {
			if(q.getAns() == q.getChose())
				result.setTotalCorrect(result.getTotalCorrect() + 1);
			else
				result.setTotalWrong(result.getTotalWrong() + 1);
		}
		
		return result;
	}
}
