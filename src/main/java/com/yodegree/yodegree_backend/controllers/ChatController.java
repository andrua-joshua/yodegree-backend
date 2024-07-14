package com.yodegree.yodegree_backend.controllers;

import com.yodegree.yodegree_backend.helpers.ChatRequest;
import com.yodegree.yodegree_backend.helpers.ChatSessionRequest;
import com.yodegree.yodegree_backend.modules.Chat;
import com.yodegree.yodegree_backend.modules.ChatSession;
import com.yodegree.yodegree_backend.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @ResponseBody
    @GetMapping("/helloworld/{id}")
    public ResponseEntity<String> helloWorld(@PathVariable("id") Integer id){
        return new ResponseEntity<>("helloword"+id, HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @PostMapping("/newChatSession")
    public ResponseEntity<ChatSession> createChatSession(
            @RequestBody @Validated ChatSessionRequest request){
        ChatSession session = chatService.newChatSession(
                request.getTitle(),
                request.getUserId()
        );

        return new ResponseEntity<ChatSession>(session, HttpStatus.ACCEPTED);
    }


    @ResponseBody
    @PostMapping("/sendMessage")
    public ResponseEntity<Chat> sendMessage(
            @RequestBody @Validated ChatRequest request){
        System.out.println("New send message request1......");
        Chat chat = chatService.sendMessage(
                request.getMessage(),
                request.getUserId(),
                request.getSessionId(),
                request.getUsername(),
                request.getImageUrl()
        );

        return new ResponseEntity<Chat>(chat, HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @GetMapping("/getChatSession/{id}")
    public ResponseEntity<ChatSession> getChatSession(
            @PathVariable("id") Integer id){
        ChatSession chatSession = chatService.getChatSessionById(id);
        return new ResponseEntity<ChatSession>(
                chatSession, HttpStatus.ACCEPTED);
    }


    @ResponseBody
    @GetMapping("/getChatSessionByUser/{id}")
    public ResponseEntity<List<ChatSession>> getChatSessionByUser(
            @PathVariable("id") Integer id){
        List<ChatSession> chatSession = chatService.getChatSessionsByUserId(id);
        return new ResponseEntity<List<ChatSession>>(
                chatSession, HttpStatus.ACCEPTED);
    }

    @ResponseBody
    @DeleteMapping("/deleteChatSession/{id}")
    public ResponseEntity<Void> deleteChatSession(
            @PathVariable("id") Integer id){
        chatService.deleteChatSession(id);
        return ResponseEntity.noContent().build();
    }

    
}
