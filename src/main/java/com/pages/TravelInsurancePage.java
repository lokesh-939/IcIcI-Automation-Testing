package com.pages;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurancePage {
    private WebDriver driver;
    
   // private By singleTripOption = By.xpath("//li[@tabindex='0']");
    private By schengenOption = By.xpath("//span[text()='Schengen']");
    private By startDate = By.id("il-start-date");
    private By continueButton = By.xpath("//a[text()='Continue']");
    private By mobileField = By.id("mul-no");
    private By emailField = By.id("mul-em");
    private By addMemberButton = By.xpath("//div[@class='il-trv-dtl']/div/a[text()='+']");
    private By planHeadings = By.xpath("//div[@class='plan-curated-heading']/div[@class='heading-block']/h4");
    private By planCosts = By.xpath("//div[@class='plan-curated-heading']/div[@class='premium-block']/div[@class='premium-details']/span");

    public TravelInsurancePage(WebDriver driver) {
        this.driver = driver;
    }

//    public void selectSingleTrip() {
//        driver.findElement(singleTripOption).click();
//    }

    public void selectSchengen() {
        driver.findElement(schengenOption).click();
    }

    public void enterDates() {
        driver.findElement(By.xpath("//*[@id=\"travel-widget\"]/app-root/app-travel-widget/div/app-single-trip/div/div[2]/app-calender/div/div[4]/div[1]/table/tbody/tr[4]/td[4]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"travel-widget\"]/app-root/app-travel-widget/div/app-single-trip/div/div[2]/app-calender/div/div[4]/div[1]/table/tbody/tr[5]/td[7]/div")).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void enterContact(String mobile, String email) {
        driver.findElement(mobileField).sendKeys(mobile);
        driver.findElement(emailField).sendKeys(email);
    }

    public void addMembers(int count) {
        WebElement plus = driver.findElement(addMemberButton);
        for (int i = 0; i < count; i++) {
            plus.click();
        }
    }

    public void printPlans() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    	//wait.until(ExpectedConditions.visibilityOfAllElements(
        List<WebElement> headings = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(planHeadings));
        List<WebElement> costs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(planCosts));
        for (int i = 0; i < headings.size(); i++) {
            System.out.println(headings.get(i).getText() + " - " + costs.get(i).getText());
        }
        //System.out.println(headings.get(0).getText() + " - " + costs.getText()+" "+headings.get(1).getText());
        
    }
}

