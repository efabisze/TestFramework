package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MaritalStatusPage {
    private WebDriver driver;

    WebElement singleButton = driver.findElement(By.xpath("//span[text()='Single']"));
    WebElement marriedButton = driver.findElement(By.xpath("//span[text()='Married']"));
    WebElement separatedButton = driver.findElement(By.xpath("//span[text()='Separated']"));
    WebElement widowedButton = driver.findElement(By.xpath("//span[text()='Widowed']"));

    public MaritalStatusPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DateOfBirthPage enterDateOfBirth(String mStatus)
    {
        Reporter.log("Enter in marital status "+ mStatus  +" button", true);

        switch (mStatus.toLowerCase())
        {
            case "single":
                singleButton.click();
                break;
            case "married":
                marriedButton.click();
                break;
            case "separated":
                separatedButton.click();
                break;
            case "widowed":
                widowedButton.click();
                break;
        }

        return new DateOfBirthPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
