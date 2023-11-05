package org.example.routes;

import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.path;

public class Routes {

PlantRoutes plantRoutes = new PlantRoutes();
    public EndpointGroup getRoutes(Javalin app) {
        return () -> {
            app.routes(() -> {
                path("/", plantRoutes.getRoutes());;
            });
        };
    }
}
