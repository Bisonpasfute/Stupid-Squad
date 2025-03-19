package com.stupidsquad.webapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Player")
public class Player {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "arrival_date", nullable = false)
    private Date arrivalDate;

}
