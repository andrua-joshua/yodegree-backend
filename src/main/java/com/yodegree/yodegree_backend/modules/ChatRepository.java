package com.yodegree.yodegree_backend.modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatRepository  extends JpaRepository<Chat, Integer> {
}
