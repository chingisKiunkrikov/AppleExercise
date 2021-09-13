package browsers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Windows10 implements Environments{

    public void setMicrosoftEdge(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "edge");
        caps.setCapability("browser_version", "93.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "Thread 2");
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            WebDriverRunner.setWebDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setBrowserByName(String name) {
        switch(name){
            case "microsoftEdge": setMicrosoftEdge();
                break;
        }
    }
}
