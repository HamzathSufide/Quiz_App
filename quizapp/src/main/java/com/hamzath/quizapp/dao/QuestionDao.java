package com.hamzath.quizapp.dao;

import com.hamzath.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question,Integer> {
    List<Question>findByCategory(String category);
    @Query(value ="Select * from Question q where q.category=:category order by Random() Limit :numQ",nativeQuery = true)
    List<Question>findRandomQuestionsByCategory(String category,int numQ);
}
