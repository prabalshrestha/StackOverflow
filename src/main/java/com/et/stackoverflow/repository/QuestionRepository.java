package com.et.stackoverflow.repository;

import com.et.stackoverflow.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    Question findByQuestionId(Integer questionId);

    @Query(value = "SELECT * from Question where to_tsvector(question || ' ' ||question_title) @@ plainto_tsquery(?1)"
            ,nativeQuery = true)
    List <Question> search(String str);

}
