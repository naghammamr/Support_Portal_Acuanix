package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrioritiesPage {
    private WebDriver driver;

    public PrioritiesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addBtnLocator = By.id("addButton");
    private By nameTextFieldLocator = By.id("nameField-3");
    private By descriptionTextAreaLocator = By.id("descriptionField");
    private By colorFieldLocator = By.id("colorField-3");
    private By idPrefixLocator = By.id("typeFieldTicket-3");
    private By reminderHoursBtnLocator = By.id("editButton-3");
    private By hoursFieldLocator = By.xpath("//tr[1]//div[@class='ant-input-number-input-wrap']"); //The tr number to be added dynamic
    private By defaultRadioBtnLocator = By.xpath("//input[@class='ant-radio-input']");
    private By saveBtnLocator = By.id("saveButton-3");
    private By cancelBtnLocator = By.id("cancelButton-3");

    public WebElement addButton() {
        return driver.findElement(addBtnLocator);
    }

    public void selectColor() {
        //driver.findElement(colorFieldLocator).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('colorField-3').value='#FFEEXX'");
    }

    public WebElement selectColor2() {
        return driver.findElement(colorFieldLocator);
    }


}
