package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlantDTO
{
    private Integer id;
    private String plantType;
    private String name;
    private Integer maxHeight;
    private Double price;

    public PlantDTO(String plantType, String name, Integer maxHeight, Double price) {
        this.plantType = plantType;
        this.name = name;
        this.maxHeight = maxHeight;
        this.price = price;
    }
}
