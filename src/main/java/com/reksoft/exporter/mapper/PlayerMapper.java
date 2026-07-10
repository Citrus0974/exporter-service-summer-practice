package com.reksoft.exporter.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.dto.PlayerDto;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {

    @Mapping(target = "nickname", source = "playerViewDto.nickName")
    Player toPlayer(PlayerViewDto playerViewDto);



    @Mapping(target = "surname", ignore = true)
    @Mapping(target = "name", ignore = true)
    Player toPlayer(PlayerDto playerDto);
}
