package com.canon.normal;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hoy")
public class SimpleOtherResource {

	public SimpleOtherResource() {
		System.err.println("fdfdf");
	}
	
//	@Consumes
//	public void test() {
//		System.out.println("hello");
//	}
	
	@GET
	@Path("/one1")
	@Produces("text/plain")
	public String sss() {
		return "sss";
	}
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "efoE";
    }
	
	@GET
	@Path("d")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEFHO() {
        return "efoefewf";
    }
	
}
