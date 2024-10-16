package com.flipfit.rest;

import com.flipfit.bean.FlipFitGymCenter;
import com.flipfit.bean.Person;
import com.flipfit.business.FlipFitAdminService;
import com.flipfit.business.FlipFitCustomerService;
import com.flipfit.business.FlipFitGymOwnerService;
import com.flipfit.business.FlipFitUserService;
import com.flipfit.dto.LoginRequest;
import com.flipfit.dto.RegisterRequest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
public class FlipFitUserController {
    private final static FlipFitUserService userService = new FlipFitUserService();
    private final static FlipFitCustomerService customerService = new FlipFitCustomerService();
    private final static FlipFitGymOwnerService gymOwnerService = new FlipFitGymOwnerService();


    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Valid LoginRequest loginRequest) {
        try {
            Person person = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            if (person != null) {
                return Response.ok("logged in, successfully").build();
            }
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid credentials!").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(@Valid RegisterRequest registerRequest) {
        try {
            if (userService.checkIfUserExists(registerRequest.getUsername(), registerRequest.getPassword())) {
                return Response.status(Response.Status.CONFLICT).entity("User already exists").build();
            } else {
                userService.register(
                        registerRequest.getUsername(),
                        registerRequest.getEmail(),
                        registerRequest.getPassword(),
                        registerRequest.getPhoneNumber(),
                        registerRequest.getGovId(),
                        registerRequest.getRole_id()
                );
            }
            return Response.ok("User registered successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

}