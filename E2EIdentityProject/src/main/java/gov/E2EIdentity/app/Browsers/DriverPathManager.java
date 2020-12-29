package gov.E2EIdentity.app.Browsers;

import gov.E2EIdentity.app.Utitlites.Settings;

import java.util.NoSuchElementException;

public class DriverPathManager {
    private static String systemPath = System.getProperty("user.dir");
    private static String osName = System.getProperty("os.name").toLowerCase();
    private static String browserName = Settings.getTestConfig("browser.name");

    public static String getChromePath() {
        if (osName.contains("linux") && browserName.contains("chrome")) {
            return systemPath + "/Drivers/Linux/chromedriver";

        } else if (osName.contains("unix") && browserName.contains("chrome")) {
            return systemPath + "/Drivers/MacOsx/chromedriver";
        } else if (osName.contains("window") && browserName.contains("chrome")) {
            return systemPath + "\\Drivers\\Windows\\chromedriver.exe";

        } else {
            throw new NoSuchElementException("no such os");
        }


    }
}
