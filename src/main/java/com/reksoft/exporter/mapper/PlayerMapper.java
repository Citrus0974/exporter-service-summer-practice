package com.reksoft.exporter.mapper;

import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {

    @Mapping(target = "nickname", source = "playerViewDto.nickName")
    @Mapping(target = "fullName", source = "playerViewDto")
    Player toPlayer(PlayerViewDto playerViewDto);

    default String mapFullName(PlayerViewDto playerViewDto){
        String combinedName = playerViewDto.getCombinedName();
        String firstName = combinedName.split(" ")[0];
        String nextNames = combinedName.substring(firstName.length()+1); //other words, after the first word and the space after it
        return firstName + " \"" + playerViewDto.getNickName() + "\" " + nextNames;
    }
}
