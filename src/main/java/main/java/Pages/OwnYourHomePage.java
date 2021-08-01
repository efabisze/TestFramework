package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class OwnYourHomePage {
    private WebDriver driver;

    WebElement ownButton = driver.findElement(By.xpath("//span[text()='Own']"));
    WebElement rentButton = driver.findElement(By.xpath("//span[text()='Rent']"));

    WebElement otherButton = driver.findElement(By.xpath("//span[text()='Other']"));

    public OwnYourHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AccidentDamagesPage clickOwnOption(String ownHome)
    {
        Reporter.log("Clicking  profile button", true);
        waitForVisibility(ownButton);

        switch (ownHome.toLowerCase())
        {
            case "own":
                ownButton.click();
                break;
            case "rent":
                rentButton.click();
                break;
            case "other":
                otherButton.click();
                break;
        }

        return new AccidentDamagesPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
