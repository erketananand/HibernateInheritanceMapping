package com.ketan.hibernateinheritancemapping.singletable.repositories;

import com.ketan.hibernateinheritancemapping.singletable.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("stMentorRepository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Override
    <S extends Mentor> S save(S entity);

    @Override
    List<Mentor> findAll();

    @Override
    Optional<Mentor> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    boolean existsById(Long id);
}
