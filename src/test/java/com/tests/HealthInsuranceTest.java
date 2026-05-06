package com.tests;

import org.testng.annotations.Test;

import com.Basepackage.BaseTest;
import com.pages.HealthInsurancePage;
import com.pages.HomePage;

public class HealthInsuranceTest extends BaseTest {

    @Test
    public void testHealthInsuranceQuote() {
        HomePage home = new HomePage(driver);
        home.openSite();
        home.clickHealthInsurance();
        home.clickHealth();

        HealthInsurancePage healthPage = new HealthInsurancePage(driver);
        healthPage.fillAdultDetails("12", "11", "1991");
        healthPage.fillContactDetails("9900990099", "hello@gmail.com", "560083", "Unknown");
        healthPage.clickGetQuote();

        healthPage.printPlans();
    }
}
