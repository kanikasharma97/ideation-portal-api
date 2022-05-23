package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.TopicDao;
import com.sap.ideationportal.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicDao topicDao;


    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicDao.findAll();
    }

    @PostMapping("/topics")
    public Topic createTopic(Topic topic) {
        return topicDao.save(topic);
    }
}
