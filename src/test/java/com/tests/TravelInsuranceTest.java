package com.tests;

import org.testng.annotations.Test;

import com.Basepackage.BaseTest;
import com.pages.HomePage;
import com.pages.TravelInsurancePage;

public class TravelInsuranceTest extends BaseTest {

    @Test
    public void testTravelInsuranceQuote() {
        HomePage home = new HomePage(driver);
        home.openSite();
        home.clickTravelInsurance();
        home.clickTravel();

        TravelInsurancePage travelPage = new TravelInsurancePage(driver);
        //travelPage.selectSingleTrip();
        travelPage.selectSchengen();
        travelPage.enterDates();
        travelPage.clickContinue();

        travelPage.enterContact("9900889999", "hello@gmail.com");
        travelPage.addMembers(2);
        travelPage.clickContinue();

        travelPage.printPlans();
    }
}

