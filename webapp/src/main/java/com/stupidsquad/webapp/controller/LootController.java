package com.stupidsquad.webapp.controller;

import com.stupidsquad.webapp.dto.LootAssignmentSearchDTO;
import com.stupidsquad.webapp.dto.LootResponseDTO;
import com.stupidsquad.webapp.model.LootAssignment;
import com.stupidsquad.webapp.service.LootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loot")
public class LootController {

    @Autowired
    private LootService lootService;

    @PostMapping("/import")
    public ResponseEntity<?> importLoot(@RequestBody List<LootAssignment> lootAssignments) {
        try {
            List<LootAssignment> allLoot = lootService.importLoot(lootAssignments);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new LootResponseDTO("success", "Data imported successfully.", allLoot));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new LootResponseDTO("error", "An unexpected error occurred.", e.getMessage()));
        }
    }

    @GetMapping("/search")
    public List<LootAssignment> searchLoot(@RequestBody LootAssignmentSearchDTO searchParams) {
        return lootService.searchLoot(searchParams);
    }
}
