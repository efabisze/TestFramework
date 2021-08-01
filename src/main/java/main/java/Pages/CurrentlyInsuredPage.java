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

public class CurrentlyInsuredPage {
    private WebDriver driver;

    WebElement insuredButton = driver.findElement(By.xpath("//span[text()='I'm insured']"));
    WebElement notInsuredButton = driver.findElement(By.xpath("//span[text()='I'm not currently insured']"));

    public CurrentlyInsuredPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ActivePolicyPage clickInsuredOption(String option)
    {
        Reporter.log("Clicking not insured", true);
        waitForVisibility(insuredButton);

        switch (option.toLowerCase())
        {
            case "insured":
                insuredButton.click();
                break;
            case "not":
            case "no":
            case "not insured":
                notInsuredButton.click();
                break;
        }

        return new ActivePolicyPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
