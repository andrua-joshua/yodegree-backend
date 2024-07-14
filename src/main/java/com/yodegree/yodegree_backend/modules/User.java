package com.yodegree.yodegree_backend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@Builder
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String userName;
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
//    @JsonIgnore
    private List<ChatSession> chatSessions;

    public User(String userName, String email, String phone, List<ChatSession> chatSessions, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.chatSessions = chatSessions;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ChatSession> getChatSessions() {
        return chatSessions;
    }

    public void setChatSessions(List<ChatSession> chatSessions) {
        this.chatSessions = chatSessions;
    }
}
