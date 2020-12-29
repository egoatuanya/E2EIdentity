package gov.E2EIdentity.app.Pages;

import gov.E2EIdentity.app.Utitlites.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    protected WebDriver driver;




    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
    //Navigate to the wikipedia homepage
    public HomePage goToHomePage() {
        String baseUrl = Settings.getTestConfig("base.url");
        driver.navigate().to(baseUrl);
        long timeout = Long.parseLong(Settings.getTestConfig("browser.time"));
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().refresh();

        return PageFactory.initElements(driver, HomePage.class);
    }

}
