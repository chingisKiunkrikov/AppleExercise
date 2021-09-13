import browsers.Environments;
import browsers.Iphone;
import browsers.MacOS;
import browsers.Windows10;

public class WebDriverFactory {
    private static volatile WebDriverFactory instance;

    public static WebDriverFactory getInstance() {
        WebDriverFactory localInstance = instance;
        if (localInstance == null) {
            synchronized (WebDriverFactory.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new WebDriverFactory();
                }
            }
        }
        return localInstance;
    }


    public void startBrowser(String browser) {
        String env = browser.substring(0, browser.indexOf("."));
        String browserName = browser.substring(browser.indexOf(".")+1);
        getEnvByName(env).setBrowserByName(browserName);
    }

    private Environments getEnvByName(String name){
        switch(name){
            case "Iphone": return new Iphone();
            case "Windows10": return new Windows10();
            case "MacOS": return new MacOS();
            default: return null;
        }
    }
}
