package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.TopicDao;
import com.sap.ideationportal.entities.Idea;
import com.sap.ideationportal.entities.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class TopicServiceImplTest {

    @InjectMocks
    TopicServiceImpl topicService;

    @Mock
    TopicDao topicDao;

    private Topic topic = new Topic();

    private List<Topic> topics = new ArrayList<>();

    @BeforeEach
    void init() {
        topic.setId(1L);
        topic.setName("ML");
        topic.setActive(true);
        topics.add(topic);
    }

    @Test
    void getAllTopics() {
        Mockito.when(topicDao.findAll()).thenReturn(topics);
        List<Topic> topicList = topicService.getAllTopics();
        assertEquals(1, topicList.size());
        Mockito.verify(topicDao, times(1)).findAll();

    }

    @Test
    void createTopic() {
        topicService.createTopic(topic);
        Mockito.verify(topicDao,times(1)).save(topic);
    }
}