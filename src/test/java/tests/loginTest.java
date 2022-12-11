package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class loginTest extends BaseTests {

    LoginPage loginPage;

    @Test
    public void superAdminCanLoginToThePortal()
    {
        loginPage = new LoginPage(driver);
        loginPage.setLoginData("sadmin@acuanix.com","P@ssw0rd");
        loginPage.clickLoginButton().click();
        System.out.println(loginPage.clickLoginButton().getText());

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
//        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));
    }


}
