package com.reksoft.exporter.service;

import com.reksoft.exporter.mapper.TeamMapper;
import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.TeamRepository;
import com.reksoft.exporter.repository.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService{
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<Team> getTeams() {
        List<TeamDto> teamDtos = teamRepository.getTeams();
        return teamMapper.toTeamList(teamDtos);
    }


}
