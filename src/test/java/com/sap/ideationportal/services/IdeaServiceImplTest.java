package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.IdeaDao;
import com.sap.ideationportal.entities.Idea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IdeaServiceImplTest {

    @InjectMocks
    IdeaServiceImpl ideaService ;

    @Mock
    IdeaDao ideaDao;

    private Idea idea = new Idea();
    private    List<Idea> ideas = new ArrayList<Idea>();


    @BeforeEach
    void init(){
        idea.setId(1);
        idea.setName("testIdea");
        idea.setContent("this is a test idea");
        idea.setActive(true);
        idea.setReadOnly(true);
        ideas.add(idea);
    }

    @Test
    void getAllIdeas() {
        Mockito.when(ideaDao.findAll()).thenReturn(ideas);
        List<Idea> ideaList = ideaService.getAllIdeas();
        assertEquals(1, ideaList.size());
        Mockito.verify(ideaDao, times(1)).findAll();

    }

    @Test
    void getIdeaById() {
        Idea idea1 = new Idea();
        idea.setId(2);
        idea.setName("testIdea");
        idea.setContent("this is a test idea");
        idea.setActive(true);
        idea.setReadOnly(true);
        Mockito.when(ideaDao.findById(2L)).thenReturn(Optional.ofNullable(idea1));
        Idea returnedIdea = ideaService.getIdeaById(2L);
        assertEquals(idea1,returnedIdea);
    }

    @Test
    void createIdea() {
        ideaService.createIdea(idea);
        Mockito.verify(ideaDao,times(1)).save(idea);
    }

    @Test
    void deleteIdea() {
        ideaService.deleteIdea(1L);
        Mockito.verify(ideaDao).deleteById(1L);
    }

    @Test
    void updateIdea() {
    }
}