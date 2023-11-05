package org.example.dao.impl;

import org.example.config.Populate;
import org.example.dao.IPlantDAO;
import org.example.dto.PlantDTO;
import org.example.exception.ApiException;

import java.util.List;



public class PlantDAOMock implements IPlantDAO
{
    public static List<PlantDTO> plantDTOList;
    public PlantDAOMock()
    {
        plantDTOList = Populate.populatePlants();
    }
    @Override
    public PlantDTO read(Integer integer) throws ApiException
    {
        PlantDTO plantDTO = plantDTOList.stream().filter(p -> p.getId() == integer).findFirst().orElse(null);
        if(plantDTO == null)
        {
            throw new ApiException(404, "Plant not found");
        }
        return plantDTO;
    }

    @Override
    public List<PlantDTO> readAll()
    {
        return plantDTOList;
    }

    @Override
    public PlantDTO create(PlantDTO plantDTO) throws ApiException
    {
        plantDTOList.add(plantDTO);
        return plantDTO;
    }

    @Override
    public PlantDTO update(Integer integer, PlantDTO plantDTO) throws ApiException
    {
        PlantDTO plantDTO1 = read(integer);
        if(plantDTO1 == null)
        {
            throw new ApiException(404, "Plant not found");
        }
        plantDTO1.setName(plantDTO.getName());
        plantDTO1.setPlantType(plantDTO.getPlantType());
        plantDTO1.setMaxHeight(plantDTO.getMaxHeight());
        plantDTO1.setPrice(plantDTO.getPrice());
        return plantDTO1;
    }

    @Override
    public void delete(Integer integer) throws ApiException
    {
        PlantDTO plantDTO = read(integer);
        if(plantDTO == null)
        {
            throw new ApiException(404, "Plant not found");
        }
        plantDTOList.remove(plantDTO);
    }

    @Override
    public List<PlantDTO> getByType(String type)
    {
        return plantDTOList.stream().filter(p -> p.getPlantType().equals(type)).toList();
    }

    public List<PlantDTO> getTallerThan100()
    {
        return plantDTOList.stream().filter(p -> p.getMaxHeight() > 100).toList();
    }
    public List<String> getPlantNames()
    {
        return plantDTOList.stream().map(PlantDTO::getName).toList();
    }
    public List<PlantDTO> sortByName()
    {
        return plantDTOList.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).toList();
    }
}
