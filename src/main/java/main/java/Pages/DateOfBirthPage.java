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

public class DateOfBirthPage {
    private WebDriver driver;

    @FindBy(id = "dateOfBirth")
    protected WebElement dobInput;

    WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));

    public DateOfBirthPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomeAddressPage clickContinue()
    {
        Reporter.log("Clicking continue button", true);
        waitForVisibility(continueButton);

        continueButton.click();

        return new HomeAddressPage(driver);
    }

    public DateOfBirthPage enterDateOfBirth(String dob)
    {
        Reporter.log("Clicking date of birth input", true);
        waitForVisibility(dobInput);

        dobInput.sendKeys(dob);

        return this;
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
