package com.AnyWare.Student.Management.System.dao;

import com.AnyWare.Student.Management.System.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
