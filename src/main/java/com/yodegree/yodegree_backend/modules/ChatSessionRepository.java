package com.yodegree.yodegree_backend.modules;

import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ChatSessionRepository extends JpaRepository<ChatSession, Integer> {
    public List<ChatSession> findAllByUserId(Integer userId);
}
