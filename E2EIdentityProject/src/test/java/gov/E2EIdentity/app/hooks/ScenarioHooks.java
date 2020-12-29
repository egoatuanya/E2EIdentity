package gov.E2EIdentity.app.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import gov.E2EIdentity.app.Browsers.BrowserFactory;

public class ScenarioHooks {
    private BrowserFactory bf;

    //@Before(order = 1)
    @Before(order=1)
    public void startTest1()
    {
        bf = new BrowserFactory();
        bf.initialiseBrowser();
    }


    @Before(order = 2)
    public void startTest2()
    {
        bf.prepareBrowser();
    }

    @After
    public void stopTest()
    {
        bf.deInitialiseBrowser();
    }
}
