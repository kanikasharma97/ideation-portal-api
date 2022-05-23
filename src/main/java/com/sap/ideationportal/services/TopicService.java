package com.sap.ideationportal.services;

import com.sap.ideationportal.entities.Topic;

import java.util.List;

public interface TopicService {

    public List<Topic> getAllTopics();
    public Topic createTopic(Topic topic) ;
}
