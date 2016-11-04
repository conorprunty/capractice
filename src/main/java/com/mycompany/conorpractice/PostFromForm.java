/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conorpractice;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author conorprunty
 */
@Path("/capractice")
public class PostFromForm {

    @POST
    @Path("/postFromForm")
    public Response addUser(
            @FormParam("name") String name,
            @FormParam("password") String password) {

        if (name.isEmpty() || password.isEmpty()) {
            return Response.status(200)
                    .entity("Either the name or the password is blank")
                    .build();
        } else {
            return Response.status(200)
                    .entity("Your name is: " + name + " and your password is: " + password)
                    .build();
        }

    }

}
