package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> getAllPost();
}
