package com.epam.java.project.entity;

public class Conference {
    private String name;
    private String topic;
    private String conferenceDate;//TODO изменить на дату

    public Conference() {
    }

    public Conference(String name, String topic, String conferenceDate) {
        this.name = name;
        this.topic = topic;
        this.conferenceDate = conferenceDate;
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
}
