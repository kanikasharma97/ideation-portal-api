package com.sap.ideationportal.controller;

import com.sap.ideationportal.entities.Idea;
import com.sap.ideationportal.entities.Topic;
import com.sap.ideationportal.services.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    //get the list of ideas
    @GetMapping("/ideas")
    public ResponseEntity<List<Idea>> getIdeas() {
        List<Idea> ideas = this.ideaService.getAllIdeas();
        if (ideas.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(ideas));
    }

    @GetMapping("/ideas/{id}")
    public ResponseEntity<Idea> getIdeaById(@PathVariable String id) {
        Idea idea = this.ideaService.getIdeaById(Long.parseLong(id));
        if (idea == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(idea));
    }

    @PostMapping("/ideas")
    public ResponseEntity<Idea> publishIdea(@RequestBody Idea idea) {
        Idea i = null;
        try {
            i = this.ideaService.createIdea(idea);
            return ResponseEntity.of(Optional.of(i));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/ideas/{id}")
    public ResponseEntity<Idea> updateIdea(@RequestBody Idea idea, @PathVariable Long id) {
        try{
            this.ideaService.updateIdea(idea, id);
            return ResponseEntity.ok().body(idea);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/ideas/{id}")
    public ResponseEntity<HttpStatus> removeIdea(@PathVariable String id) {
        {
            try {
                this.ideaService.deleteIdea(Long.parseLong(id));
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }
}
