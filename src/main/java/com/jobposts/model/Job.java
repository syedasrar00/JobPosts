package com.jobposts.model;



import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "postList")
public class Job {
    private String profile;
    private String description;
    private String location;
    private String[] skills;
    private int exp;

    public Job() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Job{ \n" +
                "Profile='" + profile + '\n' +
                "Description='" + description + '\n' +
                "Location='" + location + '\n' +
                "Skills=" + Arrays.toString(skills) +'\n' +
                "Exp=" + exp +'\n' +
                '}';
    }
}
