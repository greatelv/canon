package com.canon.normal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author cannon
 */
@Path("helloworld")
public class HelloWorldResource1 {
    public static final String CLICHED_MESSAGE = "Hello Worqld!";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return CLICHED_MESSAGE;
    }

}
