/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conorpractice;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author conorprunty
 */
@Path("/multiplier")
public class MultiplierService {

    @GET
    @Path("/mservice")
    @Produces("application/json")
    public Response MultiplierService(@Context UriInfo info) {
        Gson gson = new Gson();

        String num1 = info.getQueryParameters().getFirst("num1");
        String num2 = info.getQueryParameters().getFirst("num2");

        Multiplier m = new Multiplier();
        double result = m.multiply(Double.parseDouble(num1), Double.parseDouble(num2));
        int output = (int) result;
        return Response.status(200).entity("The answer is " + gson.toJson(output)).build();

    }
}
