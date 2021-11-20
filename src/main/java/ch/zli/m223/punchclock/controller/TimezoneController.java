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

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import ch.zli.m223.punchclock.domain.Timezone;
import ch.zli.m223.punchclock.service.TimezoneService;

@Path("/task")
public class TimezoneController {

    @Inject
    TimezoneService timezoneService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Timezone> list() {
        return timezoneService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Timezone getSingleTimezone(@PathParam Long id) {
        return timezoneService.getTimezoneById(id);
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Timezone addTimezone(Timezone entry) {
        return timezoneService.createTimezone(entry);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTimezone(@PathParam Long id){
        timezoneService.delete(id);
    }

    @PUT
    public void update(Timezone timezone){
        timezoneService.updateTimezone(timezone);
    }

}
