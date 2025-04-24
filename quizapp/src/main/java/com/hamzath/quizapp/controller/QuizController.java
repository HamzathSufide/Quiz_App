package com.hamzath.quizapp.controller;

import com.hamzath.quizapp.model.Question;
import com.hamzath.quizapp.model.QuestionResponse;
import com.hamzath.quizapp.model.QuestionWrapper;
import com.hamzath.quizapp.model.Quiz;
import com.hamzath.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam String title,@RequestParam int numQ){
        return quizService.createQuiz(category,title,numQ);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizById(@PathVariable int id ){
        return quizService.getQuizById(id);

    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable int id, @RequestBody List<QuestionResponse> response){
        return quizService.submitQuiz(id,response);
    }
}
