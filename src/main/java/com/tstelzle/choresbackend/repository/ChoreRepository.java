package com.tstelzle.choresbackend.repository;

import com.tstelzle.choresbackend.entity.Chore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChoreRepository extends JpaRepository<Chore, Long> {

    Optional<Chore> findByName(String name);
}
