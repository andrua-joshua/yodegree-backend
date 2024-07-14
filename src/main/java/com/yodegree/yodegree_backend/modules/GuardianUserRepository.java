package com.yodegree.yodegree_backend.modules;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuardianUserRepository extends JpaRepository<GuardianUser, Integer> {

    abstract public Optional<GuardianUser> findByEmail(String email);

}
