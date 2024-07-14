package com.yodegree.yodegree_backend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Records")
@Data
@NoArgsConstructor
public class AnalysisRecord {

    @Id
    @GeneratedValue
    private Integer id;
    private double pH;
    private String summary;
    private String healthImplications;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private GuardianUser user;
    private Date createdAt;


    public AnalysisRecord(
            double pH, String summary, String healthImplications,
            GuardianUser user, Date createdAt) {
        this.pH = pH;
        this.summary = summary;
        this.healthImplications = healthImplications;
        this.user = user;
        this.createdAt = createdAt;
    }


    public Integer getId() {
        return id;
    }


    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public String getHealthImplications() {
        return healthImplications;
    }

    public void setHealthImplications(String healthImplications) {
        this.healthImplications = healthImplications;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public GuardianUser getUser() {
        return user;
    }

    public void setUser(GuardianUser user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
