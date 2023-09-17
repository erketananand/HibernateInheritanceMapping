package com.ketan.hibernateinheritancemapping.singletable.repositories;

import com.ketan.hibernateinheritancemapping.singletable.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("stStudentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Override
    <S extends Student> S save(S entity);

    @Override
    Optional<Student> findById(Long aLong);

    @Override
    List<Student> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    boolean existsById(Long aLong);
}
