package com.cricketapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import com.cricketapp.entities.UpcommingMatches;
import com.cricketapp.repositories.UpcommingMatchesRepo;
import com.cricketapp.utils.LiveMatchInfo;

@RestController
public class TestController {

    @Autowired
    private UpcommingMatchesRepo upcommingMatchesRepo;

    @Autowired
    private LiveMatchInfo liveMatchInfo;

    @GetMapping("/matches")
    public ResponseEntity<List<UpcommingMatches>> upcomming(){

        return new ResponseEntity<>(upcommingMatchesRepo.findAll(), HttpStatus.OK);

    }

    @PostExchange("/update")
    public ResponseEntity<String> updateMatches(){
        try {
            liveMatchInfo.live_match_info();
            return new ResponseEntity<>("Matches updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Matches not updated ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
