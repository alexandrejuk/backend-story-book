package services;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import dao.UserLoginDAO;
import model.UserLogin;


@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

 
    public LoginResource() {
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createBook(String content) {
        Gson gson = new Gson();
        UserLogin userLogin = gson.fromJson(content, UserLogin.class);
        UserLoginDAO userLoginDAO = new UserLoginDAO();
   
        UserLogin userFind = userLoginDAO.findByName(
            userLogin.getUsername(),
            userLogin.getPassword()
        );
        return gson.toJson(userFind);
    }
   
}
