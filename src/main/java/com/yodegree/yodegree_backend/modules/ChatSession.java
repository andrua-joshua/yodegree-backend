package com.yodegree.yodegree_backend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "CHATS-SESSION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatSession {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;
    private Date createdAt;
    @OneToMany(mappedBy = "chatSession", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<Chat> chats;

    public ChatSession(String title, Date createdAt, User user, List<Chat> chats) {

        this.title = title;
        this.createdAt = createdAt;
        this.user = user;
        this.chats = chats;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
