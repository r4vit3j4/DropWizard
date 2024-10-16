package com.flipfit.rest;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.business.FlipFitGymCenterService;
import com.flipfit.business.FlipFitGymOwnerService;
import com.flipfit.business.FlipFitSlotService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("gymOwner")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitGymOwnerController {
    private final static FlipFitGymOwnerService gymOwnerService = new FlipFitGymOwnerService();
    private final static FlipFitGymCenterService gymCenterService = new FlipFitGymCenterService();
    private final static FlipFitSlotService slotService = new FlipFitSlotService();

    @POST
    @Path("/addGym")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response requestAdditionOfGym(@Valid FlipFitGymCenter newGym) {
        try {
            gymCenterService.addCenter(newGym);
            return Response.ok("Gym added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{gymOwnerId}/allGymCenters")
    public Response getAllGymCenters(@PathParam("gymOwnerId") String gymOwnerId) {
        try {
            List<FlipFitGymCenter> gymCenters =  gymCenterService.getGymCentersByOwnerId(gymOwnerId);
            return Response.ok(gymCenters).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/{gymCenterId}/addSlot")
    public Response addNewSlot(@PathParam("gymCenterId") String gymCenterId, @Valid FlipFitSlot newSlot) {
        try {
            slotService.addSlotForGym(gymCenterId, newSlot);
            return Response.ok("Slot added successfully").build();
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
