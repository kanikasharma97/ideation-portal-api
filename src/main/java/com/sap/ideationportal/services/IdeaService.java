package com.sap.ideationportal.services;

import com.sap.ideationportal.entities.Idea;

import java.util.List;


public interface IdeaService {

    public List<Idea>  getAllIdeas();

    public Idea getIdeaById(Long id);

    public Idea createIdea(Idea idea);

    public void deleteIdea(Long id);

    public Idea updateIdea(Idea idea, Long id);


}
