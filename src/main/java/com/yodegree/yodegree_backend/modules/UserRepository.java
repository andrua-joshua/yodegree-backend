package com.yodegree.yodegree_backend.modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    abstract Optional<User> findUserByEmail(String email);
}
