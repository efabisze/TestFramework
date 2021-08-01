package main.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class NamePage {
    private WebDriver driver;

    @FindBy(id = "firstName")
    protected WebElement firstNameInput;

    @FindBy(id = "lastName")
    protected WebElement lastNameInput;

    @FindBy(css = ".MuiButton-label")
    protected WebElement continueButton;

    public NamePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GenderPage clickContinue()
    {
        Reporter.log("Clicking continue button", true);
        waitForVisibility(continueButton);

        continueButton.click();

        return new GenderPage(driver);
    }

    public NamePage enterFirstName(String fname)
    {
        Reporter.log("Enter in first name", true);
        waitForVisibility(firstNameInput);

        firstNameInput.sendKeys(fname);
        return this;
    }

    public NamePage enterLastName(String lname)
    {
        Reporter.log("Enter in last name", true);
        waitForVisibility(lastNameInput);

        firstNameInput.sendKeys(lname);
        return this;
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
