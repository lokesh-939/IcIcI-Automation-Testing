package com.pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class carInsurancePage {
    private WebDriver driver;

    private By mobileField = By.id("car-registration-mob");
    private By emailField = By.id("car-registration-email");
    private By submitButton = By.id("keyboardbindLast");
    
    @FindBy(xpath="//div[@class='il-input-block']/span")
    private WebElement errorMessage ;

    public carInsurancePage(WebDriver driver) {
    	this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void enterDetails(String mobile, String email) {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField)).sendKeys(mobile);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton)).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

