package com.dileep.quizapk.Repository;

import com.dileep.quizapk.Entity.Question;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Long> {
   List<Question> getQuestionsByLanguage(String language);

    @Query(value = "SELECT * FROM questions q WHERE q.language = :language ORDER BY RAND() LIMIT :numq", nativeQuery = true)
    List<Question> findRandomQuestionsByLanguage(@Param("language") String language, @Param("numq") int numq);

}
