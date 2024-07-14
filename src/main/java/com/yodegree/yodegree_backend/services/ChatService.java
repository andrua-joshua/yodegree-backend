package com.yodegree.yodegree_backend.services;

import com.yodegree.yodegree_backend.exceptions.ResourceNotFoundException;
import com.yodegree.yodegree_backend.modules.*;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {

    //todo delete chatsession
    //todo create new chat session
    //todo sendmessage(chat)
    //todo getChatSession
    //todo get all chat sessions

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatSessionRepository chatSessionRepository;
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private RestTemplate restTemplate;

    public void deleteChatSession(Integer sessionId){
        ChatSession chatSession = chatSessionRepository.findById(
                sessionId
        ).orElseThrow(()-> new ResourceNotFoundException(
                "Chat session with id "+sessionId+" not found"));
        System.out.print("Deleting by id....."+chatSession.getUser().getId());

        chatSessionRepository.deleteById(chatSession.getUser().getId());
        System.out.print("..............Deleted by id "+chatSession.getUser().getId());
    }

    public String getData(String message){
        return "@Drillox Ai response mimics -- ^(0^0)^";
//                restTemplate.getForObject(
//                "https://ydegree.pearlbuddy.com:8090/"+message,String.class
//        );
    }

    public ChatSession newChatSession(String title, Integer userId){

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "User with id "+userId+" not found")
        );

        ChatSession chatSession = new ChatSession(
                title,
                new Date(),
                user,
                new ArrayList<Chat>()
        );

        user.getChatSessions().add(chatSession);
        userRepository.save(user);
        chatSessionRepository.save(chatSession);
        return chatSession;

    }

    public ChatSession getChatSessionById(Integer sessionId){
        return chatSessionRepository.findById(sessionId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "Chat Session with id \""+sessionId+"\" not found")
        );

    }

    public  List<ChatSession> getChatSessionsByUserId(Integer userId){
        User user  = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException(
                        "User with Id: "+userId+" not found")
        );

        return user.getChatSessions();
    }


    public Chat sendMessage(
            String message, Integer userId,
            Integer sessionId,
            String username, String imageUrl){
        ChatSession chatSession = chatSessionRepository
                .findById(sessionId)
                .orElseThrow(
                        ()-> new ResourceNotFoundException(
                                "Chat session with id "+sessionId+" not found")
                );
        Chat chat = new Chat(
                message,
                username,
                imageUrl,
                new Date(),
                chatSession
        );

        String aiMessage = getData(message);
        Chat _chat = new Chat(
                aiMessage,
                "Earthena",
                "",
                new Date(),
                chatSession
        );


//        chatSession.getChats().add(chat);
//        chatSession.getChats().add(_chat);
        Chat [] chats = new Chat[2];
        chats[0] = chat;
        chats[1] = _chat;

        chatSession.getChats().addAll(List.of(chats));

        chatRepository.save(chat);
        chatRepository.save(_chat);
        chatSessionRepository.save(chatSession);

        return _chat;
    }




}
