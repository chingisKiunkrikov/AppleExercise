package browsers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Iphone implements Environments{
    @Override
    public void setBrowserByName(String name) {
        switch(name){
            case "ios": setIOS();
                break;
        }
    }

    private void setIOS() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "iPhone 12 Pro");
        caps.setCapability("os_version", "14");
        caps.setCapability("browserName", "ios");
        caps.setCapability("realMobile", "true");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Thread 1");
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            WebDriverRunner.setWebDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
