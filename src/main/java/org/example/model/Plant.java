package org.example.model;

import org.example.exception.ApiException;

public class Plant
{
    private Integer id;
    private PlantType plantType;
    private String name;
    private Integer maxHeight;
    private Double price;

    public enum PlantType
    {
        ROSE,
        BUSH,
        FRUITANDBERRIES,
        RHODODENDRON;

        public PlantType stringToPlantType(String s) throws ApiException
        {
            return switch (s)
            {
                case "rose" -> ROSE;
                case "bush" -> BUSH;
                case "fruitandberries" -> FRUITANDBERRIES;
                case "rhododendron" -> RHODODENDRON;
                default -> throw new ApiException(404, "Invalid plant type");
            };
        }
    }
}
