package org.example.controller;

import io.javalin.http.Context;

public interface IPlantController
{
    /*
    1.4.2 A controller, PlantController, based on an interface IPlantController. The
controller methods should each return a return a json response
     */
    void getPlantById(Context ctx);
    void getAllPlants(Context ctx);
    void createPlant(Context ctx);
    void updatePlant(Context ctx);
    void deletePlant(Context ctx);
}
