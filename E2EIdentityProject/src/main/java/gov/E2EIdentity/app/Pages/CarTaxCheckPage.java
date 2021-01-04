package gov.E2EIdentity.app.Pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.stream.Collectors;

public class CarTaxCheckPage extends BasePage{

    public CarTaxCheckPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "vrm-input")
    WebElement regInputElement;

    @FindBy(xpath = "//button[text()='Free Car Check']")
    WebElement carHistCheckButtonElement;

    @FindBy(xpath = "//h5[text()='Vehicle Not Found']")
    WebElement alertTextElement;


    public CarTaxCheckPage enterValidReg1(String reg1)
    {
        regInputElement.sendKeys(reg1);
        return PageFactory.initElements(driver, CarTaxCheckPage.class);

    }
    public CarTaxCheckPage clickOnCarHistCheck() throws InterruptedException {
        Thread.sleep(2000);
        carHistCheckButtonElement.click();
        return PageFactory.initElements(driver, CarTaxCheckPage.class);
    }

    public String getVehiclesDetailsUrl() throws InterruptedException {
        Thread.sleep(2000);
       String detailsUrl = driver.getCurrentUrl();
        return detailsUrl;
    }
    public String verifyVehicleDetails() throws InterruptedException {
        Thread.sleep(2000);
        String path = "jsx-3499070155";
         return driver.findElements(By.className(path)).stream().map(WebElement::getText)
            .collect(Collectors.joining(","));

    }

    public void getAlertText(String alertText) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
       wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Assert.assertTrue(alert.getText().contains(alertText));


    }

}
