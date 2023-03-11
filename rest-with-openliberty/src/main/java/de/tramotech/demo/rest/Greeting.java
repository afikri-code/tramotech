package de.tramotech.demo.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("hello")
public class Greeting {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage() {
        return "hello world from a docker container";
    }

}
