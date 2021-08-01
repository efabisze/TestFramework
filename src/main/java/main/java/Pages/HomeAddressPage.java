package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomeAddressPage {
    private WebDriver driver;

    @FindBy(id = "streetAddress")
    protected WebElement streetAddressInput;

    @FindBy(id = "streetAddress2")
    protected WebElement aptUnitInput;

    @FindBy(id = "city")
    protected WebElement cityInput;

    @FindBy(id = "mui-component-select-state")
    protected WebElement stateDropdown;

    @FindBy(id = "zipCode")
    protected WebElement zipCodeInput;

    WebElement parkOvernight = driver.findElement(By.xpath("//input[@type='checkbox']"));
    WebElement continueButton = driver.findElement(By.xpath("//span[text()='Continue']"));

    public HomeAddressPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OwnYourHomePage clickContinue()
    {
        Reporter.log("Clicking continue button", true);
        waitForVisibility(continueButton);

        continueButton.click();

        return new OwnYourHomePage(driver);
    }

    public HomeAddressPage enterHomeAddress(String streetAddress, String aptUnit, String city, String state, String zip)
    {
        Reporter.log("Enter home address", true);
        waitForVisibility(streetAddressInput);

        streetAddressInput.sendKeys(streetAddress);
        aptUnitInput.sendKeys(aptUnit);
        cityInput.sendKeys(city);
        stateDropdown.sendKeys(state);
        zipCodeInput.sendKeys(zip);

        return this;
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
