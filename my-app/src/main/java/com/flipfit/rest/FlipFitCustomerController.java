package com.flipfit.rest;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.FlipFitSlot;
import com.flipfit.business.FlipFitCustomerService;
import com.flipfit.dto.BookSlotRequest;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlipFitCustomerController {
    private static final FlipFitCustomerService customerService = new FlipFitCustomerService();

    @GET
    @Path("/allGymCenters/{city}")
    public Response getGymCentersByCity (@PathParam("city") String city) {
        try {
            List<FlipFitGymCenter> gymCentersList = customerService.getGymCentersListByCity(city);
            return Response.ok(gymCentersList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{customerId}/allBookings")
    public Response viewAllBookings(@PathParam("customerId") String customerId) {
        try {
            List<FlipFitBooking> customerBookings = customerService.getCustomerBookings(customerId);
            return Response.ok(customerBookings).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


    @POST
    @Path("/{gymCenterId}/bookSlot")
    public Response bookSlot(@PathParam("gymCenterId") String gymCenterId, @Valid BookSlotRequest bookSlotRequest) {
        try {
            if(customerService.bookSlot(bookSlotRequest.getCustomerId(), bookSlotRequest.getDate(), bookSlotRequest.getSlotId(), gymCenterId)) {
                return Response.ok("Slot booked successfully!").build();
            };
            return Response.status(Response.Status.CONFLICT).entity("Please check the entered details").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{gymCenterId}/allSlots/")
    public Response getAllSlots (@PathParam("gymCenterId") String gymCenterId) {
        try {
            Date date = new Date();
            List<FlipFitSlot> slotList = customerService.getAvailableSlots(gymCenterId, date);
            return Response.ok(slotList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
