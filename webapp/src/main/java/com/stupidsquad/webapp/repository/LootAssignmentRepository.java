package com.stupidsquad.webapp.repository;

import com.stupidsquad.webapp.model.LootAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LootAssignmentRepository extends JpaRepository<LootAssignment, String>, JpaSpecificationExecutor<LootAssignment> {

}
