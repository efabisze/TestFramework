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
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ActivePolicyPage {
    private WebDriver driver;

    WebElement within30DaysButton = driver.findElement(By.xpath("//span[text()='Within the last 30 days']"));
    WebElement moreThan30DaysButton = driver.findElement(By.xpath("//span[text()='More than 30 days ago']"));
    WebElement neverButton = driver.findElement(By.xpath("//span[text()='Never, this is my first car']"));

    public ActivePolicyPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MoreInfoVehiclePage clickActiveOption(String option)
    {
        Reporter.log("Clicking active policy", true);
        waitForVisibility(within30DaysButton);

        switch (option.toLowerCase())
        {
            case "within 30 days":
            case "within the last 30 days":
                within30DaysButton.click();
                break;
            case "more than 30 days ago":
                moreThan30DaysButton.click();
                break;
            case "never":
            case "never, this is my first car":
            case "this is my first car":
                neverButton.click();
                break;
        }

        return new MoreInfoVehiclePage(driver);
    }


    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
