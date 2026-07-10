package com.reksoft.exporter.service;

import com.reksoft.exporter.mapper.PlayerMapper;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.repository.PlayerApiRepository;
import com.reksoft.exporter.repository.PlayerRepository;
import com.reksoft.exporter.repository.dto.PlayerViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public List<Player> getPlayers() {
        List<PlayerViewDto> playerViewDtos = playerRepository.getPlayers();
        return playerViewDtos.stream().map(playerMapper::toPlayer).toList();
    }

    @Override
    public List<Player> getPlayersByTeamName(String teamName) {
        List<PlayerViewDto> playerViewDtos = playerRepository.getPlayers();
        return playerViewDtos.stream()
                .filter(p -> p.getTeamName().equals(teamName))
                .map(playerMapper::toPlayer)
                .toList();
    }

    @Deprecated
    private Player map(PlayerViewDto playerViewDto) {
        Player player = new Player();
        player.setId(playerViewDto.getId());
        player.setCountry(player.getCountry());
        player.setNickname(playerViewDto.getCombinedName());
        player.setFullName(playerViewDto.getCombinedName());
        player.setTeamName(playerViewDto.getTeamName());
        return player;
    }
}
