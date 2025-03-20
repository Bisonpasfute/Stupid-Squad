package com.stupidsquad.webapp.service;

import com.stupidsquad.webapp.dto.LootAssignmentSearchDTO;
import com.stupidsquad.webapp.model.LootAssignment;
import com.stupidsquad.webapp.repository.LootAssignmentRepository;
import com.stupidsquad.webapp.repository.LootAssignmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LootService {

    @Autowired
    LootAssignmentRepository lootAssignmentRepository;

    public List<LootAssignment> importLoot(List<LootAssignment> lootAssignments) {
        lootAssignmentRepository.saveAll(lootAssignments);
        return lootAssignmentRepository.findAll(); //On renvoie tous les loots assignments de la table
    }

    public List<LootAssignment> searchLoot(LootAssignmentSearchDTO searchParams) {
        return lootAssignmentRepository.findAll(LootAssignmentSpecification.search(searchParams));
    }
}
