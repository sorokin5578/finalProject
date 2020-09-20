package com.epam.java.project.dao;

import com.epam.java.project.entity.Conference;

import static java.util.Objects.nonNull;
import java.util.ArrayList;
import java.util.List;

public class ConferenceDAO {
    public final List<Conference> store = new ArrayList<>();//TODO private

    public Conference getById(int id) {

        Conference result = new Conference();
        result.setId(-1);

        for (Conference conference : store) {
            if (conference.getId() == id) {
                result = conference;
                break;
            }
        }

        return result;
    }


    public boolean add(final Conference conference) {
        return store.add(conference);
    }

    public boolean delete(int id) {
        try {
            Conference conferenceFromDB = new Conference();
            conferenceFromDB.setId(-1);

            for (Conference conf : store) {
                if (conf.getId() == id) {
                    conferenceFromDB = conf;
                    break;
                }
            }
            store.remove(conferenceFromDB);
        }catch (Exception e){//TODO change exception
            return false;
        }
        return true;
    }

    public boolean edit(final Conference conference) {
        try {
            Conference conferenceFromDB = new Conference();
            conferenceFromDB.setId(-1);

            for (Conference conf : store) {
                if (conf.getId() == conference.getId()) {
                    conferenceFromDB = conf;
                    break;
                }
            }
            System.out.println(conferenceFromDB);
            String name =conference.getName();
            String topic =conference.getTopic();
            String conferenceDate = conference.getConferenceDate();
            if(nonNull(name)&&nonNull(topic)&&nonNull(conferenceDate)){
                conferenceFromDB.setName(name);
                conferenceFromDB.setTopic(topic);
                conferenceFromDB.setConferenceDate(conferenceDate);
            }
            System.out.println(conferenceFromDB);
        }catch (Exception e){//TODO change exception
            return false;
        }
        return true;
    }


}
