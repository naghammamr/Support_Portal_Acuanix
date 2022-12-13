package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.WindowManager;

import java.time.Duration;

public class BaseTests {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {

        String chromePath = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
        String firefoxPath = System.getProperty("user.dir") + "\\resources\\geckodriver.exe";

        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions option = new ChromeOptions();

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver(option);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("http://144.91.107.237:8080/sp/#/");
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterSuite(enabled = false)
    public void stopDriver() {
        driver.quit();
    }
}
