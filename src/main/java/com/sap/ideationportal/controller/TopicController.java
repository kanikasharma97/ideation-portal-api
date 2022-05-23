package com.sap.ideationportal.controller;

import com.sap.ideationportal.entities.Topic;
import com.sap.ideationportal.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {


    @Autowired
    TopicService topicService;


    @GetMapping("/topics")
    public ResponseEntity<List<Topic>> getTopics() {
        List<Topic> topics = this.topicService.getAllTopics();
        if(topics.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(topics));
    }

    @PostMapping("/topics")
    public ResponseEntity<Topic> CreateTopic(@RequestBody Topic topic) {
        Topic t = null;
        try {
            this.topicService.createTopic(topic);
            return ResponseEntity.of(Optional.of(t));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
