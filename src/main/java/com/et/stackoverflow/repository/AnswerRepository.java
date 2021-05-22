package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

}
