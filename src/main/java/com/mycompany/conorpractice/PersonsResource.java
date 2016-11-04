/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conorpractice;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author conorprunty
 */
@Path("/persons")
public class PersonsResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    PersonService personService;

    public PersonsResource() {
        personService = new PersonService();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Person> getPersons() {
        return personService.getPersonAsList();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Person> getPersonsAsHtml() {
        return personService.getPersonAsList();
    }

    @Path("delete/{person}")
    public PersonResource deletePerson(@PathParam("person") String id,
            @Context HttpServletResponse servletResponse) throws IOException {
        personService.deletePerson(id);
        servletResponse.sendRedirect("/persons/");
        return new PersonResource(uriInfo, request, id);
    }

    // URI: /rest/persons/count
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return String.valueOf("There are " + personService.getPersonsCount() + " persons.");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createPerson(@FormParam("id") String id,
            @FormParam("personname") String name,
            @FormParam("personcity") String city,
            @Context HttpServletResponse servletResponse) throws IOException {
        Person person = new Person(id, name, city);
        personService.createPerson(person);
        servletResponse.sendRedirect("./persons/");
    }

    @Path("{person}")
    public PersonResource getPerson(@PathParam("person") String id) {
        return new PersonResource(uriInfo, request, id);
    }

}
