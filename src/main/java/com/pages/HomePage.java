package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    private By travelInsurance = By.xpath("//*[@id=\"PublicWrapper\"]/div[1]/header/div[3]/div/div/div/div[5]/div/div/ul[1]/li[3]/a");
    private By travel=By.className("travel-insurance-icon");
    private By motorInsurance = By.xpath("//*[@id=\"PublicWrapper\"]/div[1]/header/div[3]/div/div/div/div[5]/div/div/ul[1]/li[1]/a");
    private By carInsurance=By.id("Car_Insurance");
    private By healthInsurance = By.xpath("//*[@id=\"PublicWrapper\"]/div[1]/header/div[3]/div/div/div/div[5]/div/div/ul[1]/li[2]/a");
    private By Health=By.id("Health_Insurance");
    public WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("https://www.icicilombard.com/");
    }

    public void clickTravelInsurance() {
        driver.findElement(travelInsurance).click();
    }
    
    public void clickTravel() {
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(travel))).click();
    }

    public void clickMotorInsurance() {
        driver.findElement(motorInsurance).click();
        
    }
    public void clickCarInsurance() {
    	
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(carInsurance))).click();
        
    }
    
   public void clickHealth() {
	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(Health))).click();
   }
    public void clickHealthInsurance() {
        driver.findElement(healthInsurance).click();
    }
}

