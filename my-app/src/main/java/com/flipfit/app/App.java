package com.flipfit.app;

import com.flipfit.rest.*;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App extends Application<Configuration>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        LOGGER.info("Registering REST resources...");
        environment.jersey().register(new FlipFitAdminController());
        environment.jersey().register(new FlipFitUserController());
        environment.jersey().register(new FlipFitGymOwnerController());
        environment.jersey().register(new FlipFitCustomerController());
    }

    public static void main(String[] args) throws Exception
    {
        new App().run(args);
    }
}
