package com.sap.ideationportal.controller;

import com.sap.ideationportal.entities.Comment;
import com.sap.ideationportal.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/ideas/{ideaId}/comments")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable Long ideaId) {
        List<Comment> comments = null;
        if(ideaId!=null){
             comments = this.commentService.getCommentByIdeaId(ideaId);
             if(comments.size()<=0){
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
             }
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.of(Optional.of(comments));
    }

    @GetMapping("/ideas/{ideaId}/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = this.commentService.getCommentById(commentId);
        if(comment == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(comment));
    }

    @PostMapping("/ideas/{ideaId}/comments")
    public ResponseEntity<Comment> publishComment(@RequestBody Comment comment, @PathVariable Long ideaId) {
        Comment c = null;
        try{
            c = this.commentService.postComment(ideaId, comment);
            return ResponseEntity.of(Optional.of(c));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/ideas/{ideaId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        try{
            this.commentService.updateComment(comment);
            return ResponseEntity.ok().body(comment);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/ideas/{ideaId}/comments/{commentId}")
    public ResponseEntity<HttpStatus> removeComment(@PathVariable Long commentId) {
        try {
            this.commentService.deleteComment(commentId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
