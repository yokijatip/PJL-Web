package yjp.pjl.PJL_Web.service;

import yjp.pjl.PJL_Web.model.Student;

import java.util.List;

public interface StudentService {
    List <Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
