package com.cricketapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpcommingMatches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;
    
    private String matchTitle;
    
    private String matchType;
    
    private String matchDate;
    
    private String matchTime;
    
    private String matchVenue;
    
    private String matchUrl;
    
    private boolean status;

}
