package tests;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
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
            driver = new ChromeDriver(getChromeOptions());

        } else if (browserName.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        driver.navigate().to("http://144.91.107.237:8080/sp/#/");
        setCookies();
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    @AfterMethod(enabled = false)
    public void takeScreenShot() throws IOException {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        Files.move(screenshot, new File("screenshots\\test.png"));
        //System.out.println("Screenshot taken and saved in this location: " + screenshot.getAbsolutePath());
    }

    @AfterMethod //a method that will run on failures
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("screenshots\\" + result.getName() + ".png"));
            } catch (IOException e) {
                System.out.println("Exception while taking screenshot" + e.getMessage());
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);// to run the test without open the browser up
        return options;
    }

    private void setCookies() {
        Cookie cookie = new Cookie.Builder("tau", "123").domain("144.91.107.237").build();
        driver.manage().addCookie(cookie);
    }

    @AfterSuite(enabled = false)
    public void stopDriver() {
        driver.quit();
    }
}
