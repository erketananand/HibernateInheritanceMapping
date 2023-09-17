package com.ketan.hibernateinheritancemapping.mappedsupperclass.repositories;

import com.ketan.hibernateinheritancemapping.mappedsupperclass.models.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("msTaRepository")
public interface TaRepository extends JpaRepository<TA, Long> {
    @Override
    <S extends TA> S save(S entity);

    @Override
    Optional<TA> findById(Long aLong);

    @Override
    List<TA> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    boolean existsById(Long aLong);
}
