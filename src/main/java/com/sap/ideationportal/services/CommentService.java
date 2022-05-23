package com.sap.ideationportal.services;


import com.sap.ideationportal.entities.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getCommentByIdeaId(Long id);

    public Comment getCommentById(Long commentId);

    public Comment postComment(Long ideaId, Comment comment);

    public Comment updateComment(Comment comment);

    public Comment deleteComment(Long commentId);


}
