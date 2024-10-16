package com.flipfit.rest;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.business.FlipFitAdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlipFitAdminController {
    private final static FlipFitAdminService adminService = new FlipFitAdminService();

    @GET
    @Path("/pendingGymCenters")
    public Response getPendingGymCentersList() {
        List<FlipFitGymCenter> pendingGymCentersList = adminService.getPendingGymCentersList();
        return Response.ok(pendingGymCentersList).build();
    }

    @GET
    @Path("/allGymCenters")
    public Response getAllGymCenters() {
        List<FlipFitGymCenter> allGymCentersList = adminService.getAllGymCentersList();
        return Response.ok(allGymCentersList).build();
    }

    @POST
    @Path("/approveGymCenter/{gymCenterId}")
    public Response approveGymCenter(@PathParam("gymCenterId") String gymCenterId) {
        try {
            adminService.approveGymCenter(gymCenterId);
            return Response.ok("Gym center approved successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/rejectGymCenter/{gymCenterId}")
    public Response rejectGymCenter(@PathParam("gymCenterId") String gymCenterId) {
        try {
            adminService.rejectGymCenter(gymCenterId);
            return Response.ok("Gym center rejected successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/removeGymCenter/{gymCenterId}")
    public Response removeGymCenter(@PathParam("gymCenterId") String gymCenterId) {
        try {
            adminService.removeGymCenter(gymCenterId);
            return Response.ok("Gym center removed successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
