package com.gsoftware.uniJogos.controller.v1.match;

import com.gsoftware.uniJogos.model.Match;
import com.gsoftware.uniJogos.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/matches")
//@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {

    private final MatchService matchService;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @PostMapping
    public Match saveMatch(@RequestBody Match match) {
        Match savedMatch = matchService.saveMatch(match);
        matchService.updateResults(savedMatch);
        return savedMatch;
    }

    @GetMapping("/group/{groupName}")
    public List<Match> getMatchesByGroupName(@PathVariable String groupName) {
        return matchService.getMatchesByGroupName(groupName);
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match match) {
        match.setId(id);
        Match updatedMatch = matchService.updateMatch(match);
        matchService.updateResults(updatedMatch);
        return updatedMatch;
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }

    @PostMapping("/generate/{groupName}")
    public List<Match> generateMatches(@PathVariable String groupName) {
        return matchService.generateMatches(groupName);
    }
}
