package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/user")
public class UserController {

    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a list of all Users",description = "Gets you a List of Users witch are saved in the DB")
    public List<User> list(){
        return userService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get one User with the specific Id",description = "Gets you the User with the specific Id you gave")
    public User getSingleUser(@PathParam Long id){
        return userService.getUserById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Will add a new User",description = "This will add a new User into the DB with your inputs")
    public User addUser(User user){
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete one User with the specific Id",description = "Delete you the User with the specific Id you gave")
    public void deleteUser(@PathParam Long id){
        userService.delete(id);
    }

    @PUT
    @Operation(summary = "Update one User with the specific Id",description = "Update you the User with the specific Id you gave")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
