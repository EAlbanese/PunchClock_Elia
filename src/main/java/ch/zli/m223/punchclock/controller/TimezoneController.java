package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import ch.zli.m223.punchclock.domain.Timezone;
import ch.zli.m223.punchclock.service.TimezoneService;

@Path("/timezone")
public class TimezoneController {

    @Inject
    TimezoneService timezoneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a list of all Timezone",description = "Gets you a List of Timezone witch are saved in the DB")
    public List<Timezone> list() {
        return timezoneService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get one Timezone with the specific Id",description = "Gets you the Timezone with the specific Id you gave")
    public Timezone getSingleTimezone(@PathParam Long id) {
        return timezoneService.getTimezoneById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Will add a new Timezone",description = "This will add a new Timezone into the DB with your inputs")
    public Timezone addTimezone(Timezone entry) {
        return timezoneService.createTimezone(entry);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete one Timezone with the specific Id",description = "Delete you the Timezone with the specific Id you gave")
    public void deleteTimezone(@PathParam Long id){
        timezoneService.delete(id);
    }

    @PUT
    @Operation(summary = "Update one Timezone with the specific Id",description = "Update you the Timezone with the specific Id you gave")
    public void update(Timezone timezone){
        timezoneService.updateTimezone(timezone);
    }

}
