package com.tests;

import org.testng.annotations.Test;

import com.Basepackage.BaseTest;
import com.pages.HomePage;
import com.pages.carInsurancePage;



public class CarInsuranceTest extends BaseTest {

    @Test
    public void testCarInsuranceErrorMessage() {
    	System.out.println(driver);
        HomePage home = new HomePage(driver);
        home.openSite();
        home.clickMotorInsurance();
        home.clickCarInsurance();

        carInsurancePage carPage = new carInsurancePage(driver);
        carPage.enterDetails("9900990099", "hello@gmail.com");

        String error = carPage.getErrorMessage();
        System.out.println("Captured Error: " + error);
    }
}

