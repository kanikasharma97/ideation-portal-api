package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.IdeaDao;
import com.sap.ideationportal.dao.TopicDao;
import com.sap.ideationportal.entities.Idea;
import com.sap.ideationportal.entities.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IdeaServiceImpl implements IdeaService {

    @Autowired
    private IdeaDao ideaDao;

    @Autowired
    private TopicDao topicDao;

    public IdeaServiceImpl(IdeaDao ideaDao) {
        this.ideaDao = ideaDao;
    }

    public List<Idea> getAllIdeas(){
        return ideaDao.findAll();
    }

    public Idea getIdeaById(Long id){
        Idea idea = null;
        try {
            idea = ideaDao.findById(id).get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return idea;
    }

    public Idea createIdea(Idea idea){
        return ideaDao.save(idea);
    }

    public void deleteIdea(Long id){
        ideaDao.deleteById(id);
    }

    public Idea updateIdea(Idea idea, Long id){
        idea.setId(id);
        return ideaDao.save(idea);
    }
}
