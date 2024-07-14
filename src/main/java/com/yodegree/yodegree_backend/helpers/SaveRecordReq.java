package com.yodegree.yodegree_backend.helpers;

public class SaveRecordReq {

    private double pH;
    private String summary;
    private String healthImplications;

    public SaveRecordReq(double pH, String summary, String healthImplications) {
        this.pH = pH;
        this.summary = summary;
        this.healthImplications = healthImplications;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public String getHelthImplications() {
        return healthImplications;
    }

    public void setHelthImplications(String helthImplications) {
        this.healthImplications = helthImplications;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

