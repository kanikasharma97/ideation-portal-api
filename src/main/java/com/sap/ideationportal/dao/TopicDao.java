package com.sap.ideationportal.dao;

import com.sap.ideationportal.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicDao extends JpaRepository<Topic, String> {
}
