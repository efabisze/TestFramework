package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LandingPage {
    private WebDriver driver;

    @FindBy(css = ".MuiButton-label")
    protected WebElement getInsuranceQuote;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public NamePage clickGetQuotes()
    {
        Reporter.log("Clicking 'Get Auto Insurance Quotes' button", true);
        waitForVisibility(getInsuranceQuote);

        getInsuranceQuote.click();
        return new NamePage(driver);
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
