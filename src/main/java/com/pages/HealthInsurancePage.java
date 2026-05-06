package com.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthInsurancePage {
    private WebDriver driver;

    private By addAdultButton = By.xpath("//div[@class='adult-count']//button[@class='plus-num js-maxpaddsadult']");
    private By dobDay = By.id("valid-adult1date");
    private By dobMonth = By.id("valid-adult1month");
    private By dobYear = By.id("valid-adult1year");
    private By addButton = By.xpath("//a[text()='Add']");
    private By mobileField = By.id("maxprotec-landing-mobile");
    private By emailField = By.id("maxprotec-landing-email");
    private By pincodeField = By.id("maxprotec-landing-pincode");
    private By nameField = By.id("maxprotec-landing-name");
    private By getQuoteButton = By.id("city-get-quote");

    private By planHeadings = By.xpath("//div[contains(@class,'insurance-pack-heading')]/h3");
    private By planCosts = By.xpath("//div[contains(@class,'insurance-pack-heading')]/following-sibling::div//p");

    public HealthInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillAdultDetails(String day, String month, String year) {
        driver.findElement(addAdultButton).click();
        driver.findElement(dobDay).sendKeys(day);
        driver.findElement(dobMonth).sendKeys(month);
        driver.findElement(dobYear).sendKeys(year);
        driver.findElement(addButton).click();
    }

    public void fillContactDetails(String mobile, String email, String pincode, String name) {
        driver.findElement(mobileField).sendKeys(mobile);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(pincodeField).sendKeys(pincode);
        driver.findElement(nameField).sendKeys(name);
    }

    public void clickGetQuote() {
        driver.findElement(getQuoteButton).click();
    }

    public void printPlans() {
    	try {
    		Thread.sleep(5000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement h1=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"plan1\"]/div[1]/div[2]/h3"))));
        WebElement cost1=driver.findElement(By.xpath("//*[@id=\"plan1\"]/div[1]/div[2]/div/div/p"));
        System.out.println(h1.getText()+"   "+cost1.getText());
        
        WebElement h2=driver.findElement(By.xpath("//*[@id=\"plan2\"]/div[1]/div/h3"));
        WebElement cost2=driver.findElement(By.xpath("//*[@id=\"plan2\"]/div[1]/div/div/div/p"));
        System.out.println(h2.getText()+"   "+cost2.getText());
        
        WebElement h3=driver.findElement(By.xpath("//*[@id=\"plan2\"]/div[1]/div/h3"));
        WebElement cost3=driver.findElement(By.xpath("//*[@id=\"plan2\"]/div[1]/div/div/div/p"));
        System.out.println(h3.getText()+"   "+cost3.getText());
    }
}
