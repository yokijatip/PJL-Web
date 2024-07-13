package yjp.pjl.PJL_Web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yjp.pjl.PJL_Web.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
