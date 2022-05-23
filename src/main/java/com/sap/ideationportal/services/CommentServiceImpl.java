package com.sap.ideationportal.services;

import com.sap.ideationportal.dao.CommentDao;
import com.sap.ideationportal.dao.IdeaDao;
import com.sap.ideationportal.entities.Comment;
import com.sap.ideationportal.entities.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    IdeaDao ideaDao;

    @Override
    public List<Comment> getCommentByIdeaId(Long id) {
        Idea idea = ideaDao.getById(id);
        List<Comment> comments = idea.getComments();
        return comments;
    }

    @Override
    public Comment getCommentById(Long commentId) {
        return commentDao.getOne(commentId);
    }

    @Override
    public Comment postComment(Long ideaId, Comment comment) {
        List<Comment> comments = new ArrayList<>();
        Idea idea = ideaDao.findById(ideaId).get();
        comment.setIdea(idea);
        comments.add(comment);
        idea.setComments(comments);
        ideaDao.save(idea);
        return comment;
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public Comment deleteComment(Long commentId) {
        Comment comment = commentDao.getById(commentId);
        comment.setActive(false);
       return commentDao.save(comment);

    }


}
