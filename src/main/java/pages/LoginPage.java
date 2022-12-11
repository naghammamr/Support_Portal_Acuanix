package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailFieldLocator = By.id("email");
    private By PasswordFieldLocator = By.id("password");
    private By loginBtnLocator = By.id("login");
    private By loggedInUserNameLocator = By.xpath("//span[@class='username']");

    public void setLoginData(String email, String password) {
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(PasswordFieldLocator).sendKeys(password);
    }

    public WebElement clickLoginButton() {
        return driver.findElement(loginBtnLocator);
    }

    public By getLoggedInUserName() {
        return loggedInUserNameLocator;
    }
}
