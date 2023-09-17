package com.ketan.hibernateinheritancemapping.tableperclass.repositories;

import com.ketan.hibernateinheritancemapping.tableperclass.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("tpcUserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(Long aLong);

    @Override
    List<User> findAll();

    @Override
    void deleteById(Long aLong);

    @Override
    boolean existsById(Long aLong);
}
