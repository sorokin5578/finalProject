package com.epam.java.project.entity;

public class Conference {
    private int id;
    private String name;
    private String topic;
    private String conferenceDate;//TODO изменить на дату
    private User speaker;

    private static int lastId=0;//TODO delete it


    public Conference() {
    }

    public Conference(String name, String topic, String conferenceDate, User speaker) {
        this.id = lastId;
        this.name = name;
        this.topic = topic;
        this.conferenceDate = conferenceDate;
        this.speaker = speaker;
        lastId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConferenceDate() {
        return conferenceDate;
    }

    public void setConferenceDate(String conferenceDate) {
        this.conferenceDate = conferenceDate;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", conferenceDate='" + conferenceDate + '\'' +
                ", speaker=" + speaker +
                '}';
    }
}
