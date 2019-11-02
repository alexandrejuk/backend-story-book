package services;

import com.google.gson.Gson;
import dao.ProductDAO;
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
import model.Product;


@Path("products")
public class ProductResource {

    @Context
    private UriInfo context;

 
    public ProductResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        ProductDAO productDAO = new ProductDAO();
   
        List<Product> products = productDAO.findAll();
        return gson.toJson(products);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createBook(@PathParam("productId") String id) {
        Gson gson = new Gson();
        ProductDAO productDAO = new ProductDAO();
   
        Product product = productDAO.findById(Long.valueOf(id));
        return gson.toJson(product);
    }
    
    @Path("{productId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerId(@PathParam("productId") String id) {
        Gson gson = new Gson();
        ProductDAO productDAO = new ProductDAO();
   
        Product product = productDAO.findById(Long.valueOf(id));
        return gson.toJson(product);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
