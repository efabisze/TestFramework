package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class TicketPage {
    private WebDriver driver;

    WebElement movingViolationButton = driver.findElement(By.xpath("//span[text()='Add a claim']"));
    WebElement noContinueButton = driver.findElement(By.xpath("//span[text()='No, continue']"));


    public TicketPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CurrentlyInsuredPage clickNoTicketOption()
    {
        Reporter.log("Clicking no ticket button", true);
        waitForVisibility(movingViolationButton);

        noContinueButton.click();

        return new CurrentlyInsuredPage(driver);
    }

    public ViolationPage clickAddViolationTicketOption()
    {
        Reporter.log("Clicking add violation button", true);
        waitForVisibility(movingViolationButton);

        noContinueButton.click();

        return new ViolationPage(driver);
    }

    private ViolationPage violationDetail(WebElement element) throws Error
    {
        return new ViolationPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
