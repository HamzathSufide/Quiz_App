package com.hamzath.quizapp.controller;

import com.hamzath.quizapp.model.Question;
import com.hamzath.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @PostMapping("/addquestions")
    public String addQuestion(@RequestBody Question question){

          questionService.addQuestion(question);
          return "good";
    }
    @DeleteMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable Integer id){
        return questionService.deleteById(id);
    }
}
