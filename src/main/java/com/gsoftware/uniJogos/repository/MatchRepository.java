package com.gsoftware.uniJogos.repository;

import com.gsoftware.uniJogos.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match,Long> {
    List<Match> findByGroupName(String groupName);
}
