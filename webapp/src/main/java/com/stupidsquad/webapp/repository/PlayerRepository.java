package com.stupidsquad.webapp.repository;

import com.stupidsquad.webapp.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
