package services;

import com.google.gson.Gson;
import dao.CustomerDAO;
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
import model.Customer;

@Path("customers")
public class CustomerResource {

    @Context
    private UriInfo context;

    public CustomerResource() {
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        CustomerDAO customerDAO = new CustomerDAO();
   
        List<Customer> books = customerDAO.findAll();
        return gson.toJson(books);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createCustomer(String content) {
        Gson gson = new Gson();
        Customer customer = gson.fromJson(content, Customer.class);
        CustomerDAO customerDAO = new CustomerDAO();
        System.out.println(customer.getUserLogin().getUsername());
        Customer response = customerDAO.save(customer);
        return gson.toJson(response);
    }
    
    @Path("{customerId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerId(@PathParam("customerId") String id) {
        Gson gson = new Gson();
        CustomerDAO customerDAO = new CustomerDAO();
   
        Customer customer = customerDAO.findById(Long.valueOf(id));
        return gson.toJson(customer);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
