package com.slavauz.jettyjerseysimple;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by slava on 26.08.16.
 */
@Path("users")
public class UsersResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String users() {
        return "Slava Uzkikh, Max Uzkikh";
    }
}
