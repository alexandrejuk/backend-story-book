package services;

import com.google.gson.Gson;
import dao.AddressDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Address;


@Path("address")
public class AddressResource {

    @Context
    private UriInfo context;

 
    public AddressResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        AddressDAO addressDAO = new AddressDAO();
   
        List<Address> addresses = addressDAO.findAll();
        return gson.toJson(addresses);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createBook(String content) {
        Gson gson = new Gson();
        AddressDAO addressDAO = new AddressDAO();
        Address address = gson.fromJson(content, Address.class);
   
        Address response = addressDAO.save(address);
        return gson.toJson(response);
    }
    
    @Path("{addressId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerId(@PathParam("addressId") String id) {
        Gson gson = new Gson();
        AddressDAO addressDAO = new AddressDAO();
   
        Address address = addressDAO.findById(Long.valueOf(id));
        return gson.toJson(address);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
