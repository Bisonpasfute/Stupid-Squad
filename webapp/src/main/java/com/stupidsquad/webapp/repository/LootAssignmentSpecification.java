package com.stupidsquad.webapp.repository;

import com.stupidsquad.webapp.dto.LootAssignmentSearchDTO;
import com.stupidsquad.webapp.model.LootAssignment;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class LootAssignmentSpecification {

    public static Specification<LootAssignment> search(LootAssignmentSearchDTO searchParams) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (searchParams.getId() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), searchParams.getId()));
            }
            if (searchParams.getPlayer() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("player"), "%" + searchParams.getPlayer() + "%"));
            }
            if (searchParams.getItemID() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("itemID"), searchParams.getItemID()));
            }
            if (searchParams.getItemString() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("itemString"), "%" + searchParams.getItemString() + "%"));
            }
            if (searchParams.getResponse() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("response"), searchParams.getResponse()));
            }
            if (searchParams.getVotes() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("votes"), searchParams.getVotes()));
            }
            if (searchParams.getPlayerClass() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("playerClass"), searchParams.getPlayerClass()));
            }
            if (searchParams.getInstance() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("instance"), searchParams.getInstance()));
            }
            if (searchParams.getBoss() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("boss"), searchParams.getBoss()));
            }
            if (searchParams.getGear1() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("gear1"), searchParams.getGear1()));
            }
            if (searchParams.getGear2() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("gear2"), searchParams.getGear2()));
            }
            if (searchParams.getResponseID() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("responseID"), searchParams.getResponseID()));
            }
            if (searchParams.getIsAwardReason() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("isAwardReason"), searchParams.getIsAwardReason()));
            }
            if (searchParams.getRollType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("rollType"), searchParams.getRollType()));
            }
            if (searchParams.getSubType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("subType"), searchParams.getSubType()));
            }
            if (searchParams.getEquipLoc() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("equipLoc"), searchParams.getEquipLoc()));
            }
            if (searchParams.getNote() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("note"), searchParams.getNote()));
            }
            if (searchParams.getOwner() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("owner"), searchParams.getOwner()));
            }
            if (searchParams.getItemName() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("itemName"), searchParams.getItemName()));
            }

            if (searchParams.getDateM() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), searchParams.getDateM()));
            } else if (searchParams.getDateStart() != null && searchParams.getDateEnd() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.between(root.get("date"), searchParams.getDateStart(), searchParams.getDateEnd()));
            } else if (searchParams.getDateStart() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("date"), searchParams.getDateStart()));
            } else if (searchParams.getDateEnd() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("date"), searchParams.getDateEnd()));
            }

            if (searchParams.getTime() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("time"), searchParams.getTime()));
            } else if (searchParams.getTimeStart() != null && searchParams.getTimeEnd() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.between(root.get("time"), searchParams.getTimeStart(), searchParams.getTimeEnd()));
            } else if (searchParams.getTimeStart() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("time"), searchParams.getTimeStart()));
            } else if (searchParams.getTimeEnd() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("time"), searchParams.getTimeEnd()));
            }

            if (searchParams.getServerTime() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("serverTime"), searchParams.getServerTime()));
            } else if (searchParams.getServerTimeStart() != null && searchParams.getServerTimeEnd() != null) {
                predicate = criteriaBuilder.and(predicate,
                        criteriaBuilder.between(root.get("serverTime"), searchParams.getServerTimeStart(), searchParams.getServerTimeEnd()));
            } else if (searchParams.getServerTimeStart() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("serverTime"), searchParams.getServerTimeStart()));
            } else if (searchParams.getServerTimeEnd() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("serverTime"), searchParams.getServerTimeEnd()));
            }

            return predicate;
        };
    }
}
