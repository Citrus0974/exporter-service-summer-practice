package com.reksoft.exporter.service;

import com.opencsv.CSVWriter;
import com.reksoft.exporter.model.Player;
import com.reksoft.exporter.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamCsvReportService {
    private final TeamService teamService;

    public File generateReport(String filePath) throws IOException {
        List<Team> teams = teamService.getTeams();

        File file = new File(filePath);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            String[] header = {"ID", "Team Name", "Players"};
            writer.writeNext(header);

            for (Team team : teams) {
                String[] line = {
                        String.valueOf(team.getId()),
                        team.getName(),
                        playerNamesString(team.getPlayers())
                };
                writer.writeNext(line);
            }
        }

        return file;
    }

    private String playerNamesString(List<Player> players){
        StringBuilder builder = new StringBuilder();
        for(Player player : players){
            builder.append(player.getCombinedName());
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }
}
