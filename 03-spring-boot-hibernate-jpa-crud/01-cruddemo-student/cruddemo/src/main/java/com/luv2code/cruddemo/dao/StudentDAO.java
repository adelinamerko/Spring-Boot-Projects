package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thestudent);
    Student findStudent(Integer Id);
    List<Student> findAll();

    List<Student> findByLastName(String thelastName);

    void update(Student theStudent);
    void delete(int Id);
    int  deleteAllStudents();

}
