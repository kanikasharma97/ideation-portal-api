package com.sap.ideationportal.dao;

import com.sap.ideationportal.entities.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeaDao extends JpaRepository<Idea, Long> {
}
