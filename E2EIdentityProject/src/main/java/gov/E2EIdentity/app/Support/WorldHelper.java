package gov.E2EIdentity.app.Support;

import gov.E2EIdentity.app.Browsers.BrowserFactory;
import gov.E2EIdentity.app.Pages.BasePage;
import gov.E2EIdentity.app.Pages.CarTaxCheckPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WorldHelper {
    private WebDriver driver = BrowserFactory.getDriver();
    private static BasePage basePage = null;
    private static CarTaxCheckPage landingPage = null;



    public  BasePage getBasePage(){
        if(basePage != null) return basePage;
        return PageFactory.initElements(driver, BasePage.class);
    }

    public CarTaxCheckPage getLandingPage(){
        if(landingPage != null) return landingPage;
        return PageFactory.initElements(driver, CarTaxCheckPage.class);
    }

}
