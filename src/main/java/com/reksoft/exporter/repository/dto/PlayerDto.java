package com.reksoft.exporter.repository.dto;

import lombok.Data;

@Data
public class PlayerDto {
    private Integer id;
    private String combinedName;
    private String nickname;
    private String country;
    private String teamName;
}
