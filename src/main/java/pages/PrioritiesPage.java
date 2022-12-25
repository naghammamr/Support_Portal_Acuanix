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
    private By okBtnLocator = By.id("ok");
    private By cancel_PopupBtnLocator = By.id("cancel");
    //private By hoursFieldLocator = By.xpath("//tr[1]//div[@class='ant-input-number-input-wrap']"); //The tr number to be added dynamic
    private By defaultRadioBtnLocator = By.xpath("//input[@class='ant-radio-input']");
    private By saveBtnLocator = By.id("saveButton-3");
    private By cancelBtnLocator = By.id("cancelButton-3");

    public WebElement addButton() {
        return driver.findElement(addBtnLocator);
    }

    public void setPriorityName(String name) {
        driver.findElement(nameTextFieldLocator).sendKeys(name);
    }

    public void setDescription(String description) {
        driver.findElement(descriptionTextAreaLocator).sendKeys(description);
    }

    public void setIdPrefixLocator(String idPrefix) {
        driver.findElement(idPrefixLocator).sendKeys(idPrefix);
    }

    public void selectDefaultValue() {
        driver.findElement(defaultRadioBtnLocator).click();
    }

    public void openReminderHoursPopup() {
        driver.findElement(reminderHoursBtnLocator).click();
    }

    public void setReminderHours(String supportIndex, String hour) {
        driver.findElement(By.xpath("//tr[" + supportIndex + "]//div[@class='ant-input-number-input-wrap']//input")).sendKeys(hour);
    }

    public WebElement saveReminderHours() {
        return driver.findElement(okBtnLocator);
    }

    public WebElement discardSavingReminderHours() {
        return driver.findElement(cancel_PopupBtnLocator);
    }

    public void saveTicketPriority() {
        driver.findElement(saveBtnLocator).click();
    }

    public void discardSavingTicketPriority() {
        driver.findElement(cancelBtnLocator).click();
    }

//    public void selectColorJS() {
//        driver.findElement(colorFieldLocator).click();
//        String sampleJS = "document.getElementById('colorField-3').value='#52fff3'";
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(sampleJS);
//    }

    public void selectColor() {
        driver.findElement(colorFieldLocator).sendKeys("#52FFF3");
    }

}