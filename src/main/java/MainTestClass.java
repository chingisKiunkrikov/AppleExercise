import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.when;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

class TestClass1 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("device", "iPhone 12 Pro");
        capsHashtable.put("os_version", "14");
        capsHashtable.put("browserName", "ios");
        capsHashtable.put("realMobile", "true");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 1");
        MainTestClass r1 = new MainTestClass();
        r1.executeTest(capsHashtable);
    }
}
class TestClass2 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "edge");
        capsHashtable.put("browser_version", "93.0");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 2");
        MainTestClass r2 = new MainTestClass();
        r2.executeTest(capsHashtable);
    }
}
class TestClass3 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "93.0");
        capsHashtable.put("os", "OS X");
        capsHashtable.put("os_version", "Big Sur");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 3");
        MainTestClass r3 = new MainTestClass();
        r3.executeTest(capsHashtable);
    }
}
public class MainTestClass {
    public static final String USERNAME = "chingiskyunkriko_tWL9Ci";
    public static final String AUTOMATE_KEY = "Ktzk964FtanTxX4yCLtC";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static void main(String[] args) throws Exception {
        Thread object1 = new Thread(new TestClass1());
        object1.start();
        Thread object2 = new Thread(new TestClass2());
        object2.start();
        Thread object3 = new Thread(new TestClass3());
        object3.start();
    }
    public void executeTest(Hashtable<String, String> capsHashtable) {
        DesiredCapabilities caps = new DesiredCapabilities();
        capsHashtable.entrySet().stream().forEach(e -> caps.setCapability(e.getKey(),e.getValue()));
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            WebDriverRunner.setWebDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        open("https://www.apple.com/");
        assert Selenide.title().equals("Apple"); //arrange
        if(capsHashtable.get("os") == null) {
            $x("//a[@id='ac-gn-menuanchor-open']").click();
        }
        List<String> links = $$x("//nav//ul[@class='ac-gn-list']//a[contains(@data-analytics-title,'')]")
                .stream()
                .filter(SelenideElement::isDisplayed)
                .map(e -> e.getAttribute("href"))
                .collect(Collectors.toList());
        links.stream().forEach(s -> sendRequest(s, capsHashtable.get("os"), capsHashtable.get("browser")));

        WebDriverRunner.closeWebDriver();
    }

    private void sendRequest(String url, String os, String browser){
        when()
                .get(url)
        .then()
                .assertThat()
                .statusCode(200);
        if(os != null) {
            System.out.println(os + " - " + browser + ": " + url + ": 200");
        }else{
            System.out.println("iphone - safari: " + url + ": 200");
        }
    }
}