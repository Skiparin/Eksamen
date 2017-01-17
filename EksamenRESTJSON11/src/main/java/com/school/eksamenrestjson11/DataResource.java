/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.eksamenrestjson11;

import static com.school.eksamenrestjson11.testdata.getData;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Orvur
 */
@Path("addresses")
public class DataResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DataResource
     */
    public DataResource() {
    }

    /**
     * Retrieves representation of an instance of com.school.eksamenrestjson11.DataResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml() {
        return "hey";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{numb}/{data}")
    public String getDataaaaaaa(@PathParam("numb") int numb, @PathParam("data") String data){
        return getData(numb, data);
    }

    /**
     * PUT method for updating or creating an instance of DataResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
