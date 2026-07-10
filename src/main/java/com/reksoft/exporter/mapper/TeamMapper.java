package com.reksoft.exporter.mapper;

import com.reksoft.exporter.model.Team;
import com.reksoft.exporter.repository.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper {

    Team toTeam(TeamDto teamDto, List<String> playerNames);

}
