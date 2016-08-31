package com.slavauz.jettyjerseysimple;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slava on 25.08.16.
 */
@Path("tasks")
public class TasksResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> tasks() {
        List<String> responce = new ArrayList<>();
        responce.add("Some simple task 1");
        responce.add("Some second simple task 2");
        responce.add("This is realy complex task 3");
        responce.add("56");
        return responce;
    }

}
