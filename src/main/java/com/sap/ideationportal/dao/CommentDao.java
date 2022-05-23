package com.sap.ideationportal.dao;

import com.sap.ideationportal.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}
