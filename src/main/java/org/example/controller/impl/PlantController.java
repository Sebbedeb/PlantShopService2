package org.example.controller.impl;

import io.javalin.http.Context;
import org.example.config.Populate;
import org.example.controller.IPlantController;
import org.example.dto.PlantDTO;

import java.util.ArrayList;
import java.util.List;

public class PlantController implements IPlantController
{
    public List<PlantDTO> plantDTOList = new ArrayList<>();

    public PlantController()
    {
        this.plantDTOList = Populate.populatePlants();
    }
    @Override
    public void getPlantById(Context ctx)
    {
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        // entity
        PlantDTO plantDTO = plantDTOList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        // response
        if(plantDTO == null)
        {
            ctx.res().setStatus(404);
            ctx.result("Plant not found");
            return;
        }
        ctx.res().setStatus(200);
        ctx.json(plantDTO, PlantDTO.class);
    }

    @Override
    public void getAllPlants(Context ctx)
    {
        ctx.res().setStatus(200);
        ctx.json(plantDTOList, PlantDTO.class);
    }

    @Override
    public void createPlant(Context ctx)
    {
        PlantDTO plantDTO = ctx.bodyAsClass(PlantDTO.class);
        plantDTO.setId(PlantDTO.counter++);
        if(plantDTO == null)
        {
            ctx.res().setStatus(400);
            ctx.result("Plant not found");
            return;
        }
        this.plantDTOList.add(plantDTO);
        ctx.res().setStatus(201);
        ctx.result("Plant created");
    }

    @Override
    public void updatePlant(Context ctx)
    {
        PlantDTO updated = ctx.bodyAsClass(PlantDTO.class);
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        PlantDTO plantDTO = plantDTOList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if(updated != null)
        {
            plantDTO.setName(updated.getName());
            plantDTO.setPlantType(updated.getPlantType());
            plantDTO.setMaxHeight(updated.getMaxHeight());
            plantDTO.setPrice(updated.getPrice());
            plantDTOList.add(plantDTO);
            ctx.res().setStatus(200);
            ctx.result("Plant updated");
        }
        else
        {
            ctx.res().setStatus(404);
            ctx.result("Plant not found");
        }
    }

    @Override
    public void deletePlant(Context ctx)
    {
        int id = ctx.pathParamAsClass("id", Integer.class).get();
        PlantDTO plantDTO = plantDTOList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if(plantDTO != null)
        {
            plantDTOList.remove(plantDTO);
            ctx.res().setStatus(200);
            ctx.result("Plant deleted");
        }
        else {
            ctx.res().setStatus(404);
            ctx.result("Plant not found");
        }
    }
}
