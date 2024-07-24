package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeamRepository extends JpaRepository<Team,Long> {
    List<Team> findByGroupName(String groupName);
}
