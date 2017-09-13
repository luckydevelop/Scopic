package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriversMethod {

    private static final  ThreadLocal<SeleniumMethods> threadLocal = new ThreadLocal<SeleniumMethods>();
    private static String browser = PropertiesFromFile.getProperties().getProperty("browser");
    private static final Logger log = Logger.getLogger(DriversMethod.class);

    public static SeleniumMethods  NewOrExistingSeleniumMethods(){
        if (threadLocal.get() == null)
        {
            threadLocal.set(new SeleniumMethods(getNewWebDriver()));
        }
        return threadLocal.get();
    }

    private static WebDriver getNewWebDriver(){
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", PropertiesFromFile.getProperties().getProperty("driver.chrome.path"));
                log.info("Chrome driver is created");
                return new ChromeDriver();
            case "Firefox":
                return new FirefoxDriver();
            default: throw new RuntimeException("Wrong browser name");
        }
    }

    public static void closeWebDriver(){
        if (threadLocal.get()!=null){
            threadLocal.get().getDriver().close();
            threadLocal.set(null);
        }
    }

}
