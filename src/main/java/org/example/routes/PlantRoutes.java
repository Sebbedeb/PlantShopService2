package org.example.routes;

import io.javalin.apibuilder.EndpointGroup;
import org.example.controller.impl.PlantController;

import static io.javalin.apibuilder.ApiBuilder.*;
import static io.javalin.apibuilder.ApiBuilder.delete;

public class PlantRoutes
{
    PlantController controller = new PlantController();

    public EndpointGroup getRoutes()
    {
        return () ->
        {
            path("/plants", () ->
            {
                post("/", controller::createPlant);
                get("/", controller::getAllPlants);
                get("/{id}", controller::getPlantById);
                put("/{id}", controller::updatePlant);
                delete("/{id}", controller::deletePlant);
            });
        };
    }
}
