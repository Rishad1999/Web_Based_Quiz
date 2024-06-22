package com.rish.quizApp.dao;

import com.rish.quizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer>
{

}
