package services;

import com.google.gson.Gson;
import dao.BookDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Book;

@Path("books")
public class BooksResource {

    @Context
    private UriInfo context;

    public BooksResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        BookDAO bookDAO = new BookDAO();
   
        List<Book> books = bookDAO.findAll();
        return gson.toJson(books);
    }
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createBook(@PathParam("bookId") String id) {
        Gson gson = new Gson();
        BookDAO bookDAO = new BookDAO();
   
        Book book = bookDAO.findById(Long.valueOf(id));
        return gson.toJson(book);
    }
    
    @Path("{bookId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBookId(@PathParam("bookId") String id) {
        Gson gson = new Gson();
        BookDAO bookDAO = new BookDAO();
   
        Book book = bookDAO.findById(Long.valueOf(id));
        return gson.toJson(book);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
