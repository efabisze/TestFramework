package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MoreInfoVehiclePage {
    private WebDriver driver;

    @FindBy(css = ".MuiSvgIcon-root")
    protected WebElement yearCarat;

    public MoreInfoVehiclePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MoreInfoVehiclePage enterYear(String year)
    {
        Reporter.log("Clicking year"+year+" button", true);
        waitForVisibility(yearCarat);

        yearCarat.click();
        WebElement yearButton = driver.findElement(By.xpath("//span[normalize-space()='"+year+"']"));
        yearButton.click();
        return this;
    }


    public MoreInfoVehiclePage enterMake(String make)
    {
        Reporter.log("Clicking make "+make+" button", true);
        WebElement makeButton = driver.findElement(By.xpath("//span[normalize-space()='"+make+"']"));

        waitForVisibility(makeButton);

        makeButton.click();
        return this;
    }

    public MoreInfoVehiclePage enterModel(String model)
    {
        Reporter.log("Clicking Moidel "+model+" button", true);
        WebElement modelButton = driver.findElement(By.xpath("//span[normalize-space()='"+model+"']"));

        waitForVisibility(modelButton);

        modelButton.click();
        return this;
    }

    private void waitForVisibility(WebElement element) throws Error
    {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
