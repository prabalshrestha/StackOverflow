package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    List<Answer> findAnswersByQuestion_QuestionId(int questionId);
}
