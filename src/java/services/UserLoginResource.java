package services;

import com.google.gson.Gson;
import dao.UserLoginDAO;
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
import model.UserLogin;

@Path("users")
public class UserLoginResource {

    @Context
    private UriInfo context;

    public UserLoginResource() {
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createBook(@PathParam("userLoginId") String id) {
        Gson gson = new Gson();
        UserLoginDAO userLoginDAO = new UserLoginDAO();
   
        UserLogin userLogin = userLoginDAO.findById(Long.valueOf(id));
        return gson.toJson(userLogin);
    }
    
    @Path("{userLoginId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomerId(@PathParam("userLoginId") String id) {
        Gson gson = new Gson();
        UserLoginDAO userLoginDAO = new UserLoginDAO();
   
        UserLogin userLogin = userLoginDAO.findById(Long.valueOf(id));
        return gson.toJson(userLogin);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
