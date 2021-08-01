package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.List;
import java.util.Random;


public class ViolationPage {
    private WebDriver driver;

    @FindBy(id = "type")
    protected WebElement whatHappened;

    @FindBy(id = "interval")
    protected WebElement whenDidItHappen;

    WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));


    public ViolationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TicketPage selectRandomDetails()
    {
        Reporter.log("Clicking Details", true);
        waitForVisibility(whatHappened);

            whatHappened.click();

        List<WebElement> happenedOptions = driver.findElements(By.xpath("//ul[@role = 'listbox']//li[@role = 'option']"));
        Random rand = new Random();
        happenedOptions.get(rand.nextInt(happenedOptions.size())).click();

        whenDidItHappen.click();
        List<WebElement> whenOptions = driver.findElements(By.xpath("//ul[@role = 'listbox']//li[@role = 'option']"));
        whenOptions.get(rand.nextInt(whenOptions.size())).click();

        continueButton.click();

        return new TicketPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
