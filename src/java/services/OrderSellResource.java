package services;

import com.google.gson.Gson;
import dao.OrderSellDAO;
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
import model.OrderSell;

@Path("ordersSell")
public class OrderSellResource {

    @Context
    private UriInfo context;

    public OrderSellResource() {
    }

     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        OrderSellDAO orderSellDAO = new OrderSellDAO();
   
        List<OrderSell> ordersSell = orderSellDAO.findAll();
        return gson.toJson(ordersSell);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createBook(String content) {
        Gson gson = new Gson();
        OrderSell orderSell = gson.fromJson(content, OrderSell.class);
        OrderSellDAO orderSellDAO = new OrderSellDAO();
        return gson.toJson(orderSell);
    }
    
    @Path("{orderSellId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerId(@PathParam("orderSellId") String id) {
        Gson gson = new Gson();
        OrderSellDAO orderSellDAO = new OrderSellDAO();
   
        OrderSell orderSell = orderSellDAO.findById(Long.valueOf(id));
        return gson.toJson(orderSell);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
      Gson gson = new Gson();
      OrderSell orderSell = gson.fromJson(content, OrderSell.class);
      OrderSellDAO orderSellDAO = new OrderSellDAO();
      return gson.toJson(orderSell);
    }
}
