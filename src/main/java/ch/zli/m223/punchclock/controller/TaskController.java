package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.domain.Timezone;
import ch.zli.m223.punchclock.service.TaskService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/task")
public class TaskController {

    @Inject
    TaskService taskService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a list of all Task",description = "Gets you a List of Taks witch are saved in the DB")
    public List<Task> list(){
        return taskService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get one Task with the specific Id",description = "Gets you the Task with the specific Id you gave")
    public Task getSingleTaskById(@PathParam Long id) {
        return taskService.getTaskById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Will add a new Task",description = "This will add a new Task into the DB with your inputs")
    public Task addTask(Task task){
        return taskService.createTask(task);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete one Task with the specific Id",description = "Delete you the Task with the specific Id you gave")
    public void deleteTask(@PathParam Long id){
        taskService.delete(id);
    }

    @PUT
    @Operation(summary = "Update one Task with the specific Id",description = "Update you the Task with the specific Id you gave")
    public void updateTask(Task task){
        taskService.updateTask(task);
    }

}
