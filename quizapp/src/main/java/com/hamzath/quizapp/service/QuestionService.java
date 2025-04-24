package com.hamzath.quizapp.service;

import com.hamzath.quizapp.dao.QuestionDao;
import com.hamzath.quizapp.model.Question;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question>getAllQuestions() {
        return questionDao.findAll();
    }
        public String addQuestion(Question question){
             questionDao.save(question);
             return "sucess";
        }

    public String deleteById(Integer id) {
        questionDao.deleteById(id);
        return "sucess";
    }
}
