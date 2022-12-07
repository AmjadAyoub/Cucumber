package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CommonMethods {

    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication() {
        ConfiqReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfiqReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Invalid browser name");

        }
        driver.manage().window().maximize();
        driver.get(ConfiqReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(10,SECONDS);
    }
}
