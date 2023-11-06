package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Plant;

@Setter
@Getter
@NoArgsConstructor
public class PlantDTO
{
    private Integer id;
    private String plantType;
    private String name;
    private Integer maxHeight;
    private Double price;

    public static int counter = 1;

    public PlantDTO(String plantType, String name, Integer maxHeight, Double price) {
        this.id = counter++;
        this.plantType = plantType;
        this.name = name;
        this.maxHeight = maxHeight;
        this.price = price;
    }

    public PlantDTO(Plant plant)
    {
        this.id = plant.getId();
        this.plantType = plant.getPlantType().toString();
        this.name = plant.getName();
        this.maxHeight = plant.getMaxHeight();
        this.price = plant.getPrice();
    }
}
