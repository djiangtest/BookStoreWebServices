package com.secondtreasuresbookstore.ws;

/**
 * @author tony jiang
 *
 */

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.secondtreasuresbookstore.model.Book;
import com.secondtreasuresbookstore.model.BookStore;

@Path("services")
public class BookStoreBackEndWS {
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Book[] getAll() {
		return BookStore.store.getAllBooks();
	}
	
	@GET
	@Path("findBookByID/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public WSResult getBookByID(@PathParam("id") String isbn) {
		
		Book book = BookStore.store.getBookByID(isbn);
        WSResult wsResult = new WSResult();
        if(book != null) {
        	wsResult.success = true;
        	wsResult.message = "Book has been found.";
        	wsResult.book = book;
        } else {
        	wsResult.success = false;
        	wsResult.message = "Book does not exist.";
        }
        return wsResult;
	}
	
    @POST
    @Path("addBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public WSResult addBook(Book book) {
    	
        int result = BookStore.store.addBook(book);
        WSResult wsResult = new WSResult();
        if(result == 0) {
        	wsResult.success = true;
        	wsResult.message = "New book has been inserted.";
        } else if(result == 1){
        	wsResult.success = false;
        	wsResult.message = "Book already exists.";
        } else {
        	wsResult.success = false;
        	wsResult.message = "Unknown error.";
        }
        return wsResult;
    }
    
    @GET
    @Path("removeBook/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public WSResult removeBook(@PathParam("id") String isbn) {
    	
        int result = BookStore.store.removeBook(isbn);
        WSResult wsResult = new WSResult();
        if(result == 0) {
        	wsResult.success = true;
        	wsResult.message = "Book has been deleted.";
        } else if(result == 1){
        	wsResult.success = true;
        	wsResult.message = "Book does not exist.";
        } else {
        	wsResult.success = false;
        	wsResult.message = "Unknown error.";
        }
        return wsResult;
    }
	
    @POST
	@Path("updateBook")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public WSResult updateBook(Book book) {
    	
		int result = BookStore.store.updateBook(book);
        WSResult wsResult = new WSResult();
        if(result == 0) {
        	wsResult.success = true;
        	wsResult.message = "Book has been updated.";
        } else if(result == 1){
        	wsResult.success = false;
        	wsResult.message = "Book does not exist.";
        } else {
        	wsResult.success = false;
        	wsResult.message = "Unknown error.";
        }
        return wsResult;
	}
    
    public class WSResult {
    	public boolean success;
    	public String message;
    	public Book book;
    }
}
