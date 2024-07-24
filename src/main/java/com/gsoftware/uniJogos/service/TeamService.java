package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.model.Team;
import com.gsoftware.uniJogos.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public List<Team> getTeamsByGroupName(String groupName) {
        return teamRepository.findByGroupName(groupName);
    }
}
