package com.slavauz.jettyjerseysimple;

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

    private static class Person {
        private String name;
        private String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> users() {
        List<Person> responce = new ArrayList<>();
        responce.add(new Person("Slava", "Uzkikh"));
        responce.add(new Person("Max", "Uzkikh"));
        return responce;
    }
}
