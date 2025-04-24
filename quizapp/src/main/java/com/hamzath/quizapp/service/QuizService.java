package com.hamzath.quizapp.service;

import com.hamzath.quizapp.dao.QuestionDao;
import com.hamzath.quizapp.dao.QuizDao;
import com.hamzath.quizapp.model.Question;
import com.hamzath.quizapp.model.QuestionResponse;
import com.hamzath.quizapp.model.QuestionWrapper;
import com.hamzath.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, String title, int numQ){
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(int id) {
      Optional<Quiz> quiz= quizDao.findById(id);
      List<Question>questions=quiz.get().getQuestions();
      List<QuestionWrapper>userQuestions=new ArrayList<>();
      for (Question question: questions){
          QuestionWrapper qw= new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
      userQuestions.add(qw);
      }
        return new ResponseEntity<>(userQuestions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int id, List<QuestionResponse> response) {
       Optional<Quiz> quiz=quizDao.findById(id);
       List<Question>questions=quiz.get().getQuestions();
       int right=0;
       int i=0;
       for(QuestionResponse responses:response){
           if(responses.getRightAnswer().equals(questions.get(i).getRightAnswer()))
               right++;
               i++;

       }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
