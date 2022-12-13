package tests;

import data.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class loginTest extends BaseTests {

    LoginPage loginPage;

    @DataProvider(name="ExcelData")
    public Object[][] userRegisterData() throws IOException
    {
        ExcelReader ER = new ExcelReader();
        return ER.getDataFromExcel();
    }

    @Test(dataProvider="ExcelData")
    public void CustomerLoginFromExcel(String email, String password)
    {
        loginPage = new LoginPage(driver);
        System.out.println("Logged In Email is " + email + ", and the password is " + password);
        loginPage.setLoginData(email,password);
        loginPage.clickLoginButton().click();
        System.out.println(loginPage.clickLoginButton().getText());
    }

    @Test
    public void superAdminCanLoginToThePortal()
    {
        loginPage = new LoginPage(driver);
        loginPage.setLoginData("sadmin@acuanix.com","P@ssw0rd");
        loginPage.clickLoginButton().click();
        System.out.println(loginPage.clickLoginButton().getText());
    }
}
