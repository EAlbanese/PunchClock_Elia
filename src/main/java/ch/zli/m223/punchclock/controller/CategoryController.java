package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Timezone;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.TimezoneService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryController {

    @Inject
    CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a list of all Category",description = "Gets you a List of Category witch are saved in the DB")
    public List<Category> list() {
        return categoryService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Will add a new Category",description = "This will add a new Category into the DB with your inputs")
    public Category addTimezone(Category category) {
        return categoryService.createTimezone(category);
    }

}
