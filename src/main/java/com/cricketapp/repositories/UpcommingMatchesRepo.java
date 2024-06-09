package com.cricketapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricketapp.entities.UpcommingMatches;

public interface UpcommingMatchesRepo extends JpaRepository<UpcommingMatches, Integer>{

}
