package com.yodegree.yodegree_backend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "CHATS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat {

    @Id
    @GeneratedValue
    private Integer id;
    private String message;
    private String username;
    private String ImageUrl;
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "chatSession_id", referencedColumnName = "id")
    @JsonIgnore
    private ChatSession chatSession;

    public Chat(String message, String username, String imageUrl, Date createdAt, ChatSession chatSession) {
        this.message = message;
        this.username = username;
        ImageUrl = imageUrl;
        this.createdAt = createdAt;
        this.chatSession = chatSession;
    }
//
//    public Chat() {
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ChatSession getChatSession() {
        return chatSession;
    }

    public void setChatSession(ChatSession chatSession) {
        this.chatSession = chatSession;
    }
}
