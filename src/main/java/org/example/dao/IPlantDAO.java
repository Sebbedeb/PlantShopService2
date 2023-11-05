package org.example.dao;

import org.example.dto.PlantDTO;

import java.util.List;
public interface IPlantDAO extends IDao<PlantDTO, Integer>
{
    List<PlantDTO> getByType(String type);
}
