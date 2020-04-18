package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before("@driver")
    public void specialSetup(){
        System.out.println("Setup for driver only");
    }

    @After("@driver")
    public void specialTeardown(){
        System.out.println("Tear down for driver only");
    }


    @After
    public void teardown(){
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
