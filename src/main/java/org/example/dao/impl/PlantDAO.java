package org.example.dao.impl;

import org.example.dao.IPlantDAO;
import org.example.dto.PlantDTO;
import org.example.exception.ApiException;

import java.util.List;

public class PlantDAO implements IPlantDAO
{

    @Override
    public PlantDTO read(Integer integer) throws ApiException
    {
        return null;
    }

    @Override
    public List<PlantDTO> readAll()
    {
        return null;
    }

    @Override
    public PlantDTO create(PlantDTO plantDTO) throws ApiException
    {
        return null;
    }

    @Override
    public PlantDTO update(Integer integer, PlantDTO plantDTO) throws ApiException
    {
        return null;
    }

    @Override
    public void delete(Integer integer) throws ApiException
    {

    }

    @Override
    public List<PlantDTO> getByType(String type)
    {
        return null;
    }
}
