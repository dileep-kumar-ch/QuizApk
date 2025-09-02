package com.dileep.quizapk.Repository;

import com.dileep.quizapk.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepo extends JpaRepository<Quiz,Long> {

}
