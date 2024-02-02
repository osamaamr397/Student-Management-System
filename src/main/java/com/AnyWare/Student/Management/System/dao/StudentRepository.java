package com.AnyWare.Student.Management.System.dao;


import com.AnyWare.Student.Management.System.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
