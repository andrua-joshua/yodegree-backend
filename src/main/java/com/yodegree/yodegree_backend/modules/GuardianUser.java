package com.yodegree.yodegree_backend.modules;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "Guardian-users")
@Data
@NoArgsConstructor
public class GuardianUser {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String email;
    private String username;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<AnalysisRecord> records;

    public GuardianUser(
            String email, String username, String phone,
            String password, List<AnalysisRecord> records) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.records = records;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<AnalysisRecord> getRecords() {
        return records;
    }

    public void setRecords(List<AnalysisRecord> records) {
        this.records = records;
    }
}
