package tests;

import data.ExcelReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
import java.time.Duration;

public class loginTest extends BaseTests {

    LoginPage loginPage;

    @DataProvider(name = "ExcelData")
    public Object[][] userRegisterData() throws IOException {
        ExcelReader ER = new ExcelReader();
        return ER.getDataFromExcel();
    }

    @Test(dataProvider = "ExcelData")
    public void CustomerLoginFromExcel(String email, String password) {
        loginPage = new LoginPage(driver);
        System.out.println("Logged In Email is " + email + ", and the password is " + password);
        loginPage.setLoginData(email, password);
        loginPage.clickLoginButton().click();
        System.out.println(loginPage.clickLoginButton().getText());
    }

    @Test
    public void superAdminCanLoginToThePortal() {
        loginPage = new LoginPage(driver);

        loginPage.setLoginData("sadmin@acuanix.com", "P@ssw0rd");
        Assert.assertEquals(loginPage.clickLoginButton().getText(), "Login");
        loginPage.clickLoginButton().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(loginPage.clickLoginButton()));

        Assert.assertTrue(driver.getCurrentUrl().contains("sp/#/home/dashboard"));

        System.out.println(loginPage.getLoggedInUserName().getText());
        Assert.assertFalse(loginPage.getLoggedInUserName().getText().isEmpty());
    }
}
