import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.when;

public class ExerciseOne {

    @ParameterizedTest
    @ValueSource(strings = {"MacOS.chrome", "Windows10.microsoftEdge","Iphone.ios"})
    public void testLinksFromTopNavigation(String browser){
        WebDriverFactory.getInstance().startBrowser(browser);
        open("https://www.apple.com/");
        assert Selenide.title().equals("Apple"); //arrange
        if(browser.contains("Iphone")) {
            $x("//a[@id='ac-gn-menuanchor-open']").click();
        }
        List<String> links = $$x("//nav//ul[@class='ac-gn-list']//a[contains(@data-analytics-title,'')]")
                .stream()
                .filter(SelenideElement::isDisplayed)
                .map(e -> e.getAttribute("href"))
                .collect(Collectors.toList());
        links.stream().forEach(s -> sendRequest(s, browser));
    }

    private void sendRequest(String url, String browser){
        when()
                .get(url) //act
        .then()
                .assertThat()
                .statusCode(200); //assert
        System.out.println(browser + ": " + url + ": 200");
    }

    @AfterEach
    public void closeWebDriver(){
        WebDriverRunner.closeWebDriver();
    }
}
