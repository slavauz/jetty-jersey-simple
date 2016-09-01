package com.slavauz.jettyjerseysimple;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slava on 26.08.16.
 */
@Path("users")
public class UsersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> users() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        List<Person> responce = (List<Person>)em.createQuery("SELECT p FROM Person p").getResultList();
        return responce;
    }
}
