package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/auth")
public class AuthenticationController {

    @Inject
    AuthenticationService authenticationService;

    @POST
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Will add a new Authentication",description = "This will add a new Authentication into the DB with your inputs")
    public String Login(User user){
        if(authenticationService.checkHashedPassword(user.getEmail(), user.getPassword())){
            return authenticationService.GenerateValidJwtToken(authenticationService.getUserByEmail(user.getEmail()));
        }else{
            throw new NotAuthorizedException("");
        }

    }

}
