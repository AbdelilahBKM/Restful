package com.example.restful.Rest;

import com.example.restful.Entity.User;
import com.example.restful.Service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/User")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    private UserService userService;

    @POST
    public Response createUser(User user){
        userService.AddUser(user);
        return Response.status(Response.Status.CREATED).build();
    }
    @GET
    @Path("/{id}")
    public Response getUser(long id){
        User user = userService.getUser(id);
        if (user == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(user).build();
    }
    @GET
    public Response getAllUsers(){
        List<User> users = userService.getUsers();
        return Response.ok(users).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") long id ,User user){
        user.setId(id);
        userService.updateUser(user);
        return Response.ok(user).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long id){
        userService.deleteUser(id);
        return Response.noContent().build();
    }
}
