package com.gsoftware.uniJogos.controller.v1.team;

import com.gsoftware.uniJogos.model.Team;
import com.gsoftware.uniJogos.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/teams")
//@CrossOrigin(origins = "http://localhost:3000")
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team saveTeam(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        team.setId(id);
        return teamService.updateTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/group/{groupName}")
    public List<Team> getTeamsByGroupName(@PathVariable String groupName) {
        return teamService.getTeamsByGroupName(groupName);
    }
}
