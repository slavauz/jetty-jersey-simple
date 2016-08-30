package com.slavauz.jettyjerseysimple;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by slava on 25.08.16.
 */
@Path("tasks")
public class TasksResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tasks() {
        return
                "Some simple task 1, Some second simple task 2, This is realy complex task 3";
    }
/*
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray tasks() {
        return Json.createArrayBuilder()
                .add("Some simple task 1")
                .add("Some second simple task 2")
                .add("This is realy complex task 3").build();
    }
    */
}
