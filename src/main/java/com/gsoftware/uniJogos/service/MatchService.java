package com.gsoftware.uniJogos.service;

import com.gsoftware.uniJogos.model.Match;
import com.gsoftware.uniJogos.model.Team;
import com.gsoftware.uniJogos.repository.MatchRepository;
import com.gsoftware.uniJogos.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;

    private final TeamRepository teamRepository;

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match updateMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public List<Match> generateMatches(String groupName, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<Team> teams = teamRepository.findByGroupName(groupName);
        List<Match> matches = new ArrayList<>();

        long intervalMinutes = ChronoUnit.MINUTES.between(startDateTime, endDateTime) / (teams.size() * (teams.size() - 1) / 2);
        LocalDateTime currentDateTime = startDateTime;

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                Match match = new Match();
                match.setHomeTeam(teams.get(i));
                match.setAwayTeam(teams.get(j));
                match.setGroupName(groupName);
                match.setDateTime(currentDateTime);
                match.setStatus("A Realizar");
                matches.add(match);
                currentDateTime = currentDateTime.plusMinutes(intervalMinutes);
            }
        }

        Collections.shuffle(matches);
        return matchRepository.saveAll(matches);
    }
    public void updateResults(Match match) {
        match.setStatus("FIM");
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        // Atualiza gols marcados e sofridos
        homeTeam.setGoalsFor(homeTeam.getGoalsFor() + match.getHomeGoals());
        homeTeam.setGoalsAgainst(homeTeam.getGoalsAgainst() + match.getAwayGoals());

        awayTeam.setGoalsFor(awayTeam.getGoalsFor() + match.getAwayGoals());
        awayTeam.setGoalsAgainst(awayTeam.getGoalsAgainst() + match.getHomeGoals());

        // Atualiza quantidade de jogos
        homeTeam.setGamesPlayed(homeTeam.getGamesPlayed() + 1);
        awayTeam.setGamesPlayed(awayTeam.getGamesPlayed() + 1);

        // Atualiza vitórias, derrotas e empates
        if (match.getHomeGoals() > match.getAwayGoals()) {
            homeTeam.setWins(homeTeam.getWins() + 1);
            homeTeam.setPoints(homeTeam.getPoints() + 3);
            awayTeam.setLosses(awayTeam.getLosses() + 1);
        } else if (match.getHomeGoals() < match.getAwayGoals()) {
            awayTeam.setWins(awayTeam.getWins() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 3);
            homeTeam.setLosses(homeTeam.getLosses() + 1);
        } else {
            homeTeam.setDraws(homeTeam.getDraws() + 1);
            awayTeam.setDraws(awayTeam.getDraws() + 1);
            homeTeam.setPoints(homeTeam.getPoints() + 1);
            awayTeam.setPoints(awayTeam.getPoints() + 1);
        }

        teamRepository.save(homeTeam);
        teamRepository.save(awayTeam);
    }

    public List<Match> getMatchesByGroupName(String groupName) {
        return matchRepository.findByGroupName(groupName);
    }

    public List<Match> findAll(){
        return matchRepository.findAll();
    }
}
