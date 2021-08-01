package main.java.Pages;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AccidentDamagesPage {
    private WebDriver driver;

    WebElement addClaimButton = driver.findElement(By.xpath("//span[text()='Add a claim']"));
    WebElement noContinueButton = driver.findElement(By.xpath("//span[text()='No, continue']"));

    public AccidentDamagesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TicketPage clickAddClaimOption()
    {
        Reporter.log("Clicking add claim button", true);
        waitForVisibility(addClaimButton);

        addClaimButton.click();

        return new TicketPage(driver);
    }

    public TicketPage clickNoClaimOption()
    {
        Reporter.log("Clicking no continue button", true);
        waitForVisibility(addClaimButton);

        noContinueButton.click();

        return new TicketPage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
