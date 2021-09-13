package browsers;

import org.openqa.selenium.WebDriver;

public interface Environments {
    public static final String USERNAME = "chingiskyunkriko_tWL9Ci";
    public static final String AUTOMATE_KEY = "Ktzk964FtanTxX4yCLtC";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public void setBrowserByName(String name);
}
