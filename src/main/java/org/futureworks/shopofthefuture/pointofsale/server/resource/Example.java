package org.futureworks.shopofthefuture.pointofsale.server.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("example")
public class Example {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/example/{id}")
    public String expectsID(@PathParam("id") int id){
    	return id+"";
    }
    
    @POST
    @Path("/example")
	@Produces(MediaType.TEXT_PLAIN)
	public String shoppingList(@PathParam("{shoppingCart}") String shoppingCart){
		//Map<String, Integer> barcodes = parser.parseMobileShoppingCart();
		//while
		
		return "It works!";
	}
}
