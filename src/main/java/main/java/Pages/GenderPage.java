package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class GenderPage {
    private WebDriver driver;

    WebElement maleButton = driver.findElement(By.xpath("//span[text()='Male']"));
    WebElement femaleButton = driver.findElement(By.xpath("//span[text()='Female']"));

    public GenderPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MaritalStatusPage clickGenderButton(String gender)
    {
        Reporter.log("Clicking gender "+gender+" button", true);

        waitForVisibility(femaleButton);

        switch (gender.toLowerCase())
        {
            case "m":
            case "male":
                maleButton.click();
                break;
            case "f":
            case "female":
                femaleButton.click();
                break;

        }

        return new MaritalStatusPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
