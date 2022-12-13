package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SupportTypesPage {

    private WebDriver driver;

    public SupportTypesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addBtnLocator = By.id("addButton");
    private By supportTypeNameFieldLocator = By.id("supportTypeNameField-2");
    private By descriptionFieldLocator = By.id("descriptionField-2");
    private By supportHoursBtnLocator = By.id("editButton-2");
    private By workingHrsFieldLocator = By.id("businessHoursField");
    private By startingTimeFieldLocator = By.xpath("//input[@class='ng-tns-c182-172 ng-pristine ng-valid ng-touched']");
    //private By workingDaysLocator = By.xpath("//tr//td//div[1]//input[@class='ant-checkbox-input ng-untouched ng-pristine ng-valid']");
    private By idPatternDropDownLocator = By.xpath("//input[@class='ant-select-selection-search-input ng-untouched ng-pristine ng-valid']");
    private By textIDPatternLocator = By.xpath("//div[text()='TEXT']");
    private By numberIDPatternLocator = By.xpath("//div[text()='NUMBER']");
    private By okBtnLocator = By.xpath("//button[@class='ant-btn ant-btn-primary ng-star-inserted']");
    private By cancelPopup_BtnLocator = By.xpath("//button[@class='ant-btn ng-star-inserted']");
    private By saveBtnLocator = By.id("saveButton-2");
    private By cancelBtnLocator = By.id("cancelButton-2");

    private By clearTimeLocator = By.xpath("//span[@class='ant-picker-clear ng-tns-c182-164 ng-star-inserted']");


    //////////////////////////////

    public WebElement addButton() {
        return driver.findElement(addBtnLocator);
    }

    public void specifyName(String supportTypeName) {
        driver.findElement(supportTypeNameFieldLocator).sendKeys(supportTypeName);
    }

    public void specifyDescription(String supportTypeDesc) {
        driver.findElement(descriptionFieldLocator).sendKeys(supportTypeDesc);
    }

    public void selectIDPattern_TEXT(String idPatternVisibleText) {
        driver.findElement(idPatternDropDownLocator).click();
        driver.findElement(textIDPatternLocator).click();
    }

    public WebElement supportHoursPopupButton() {
        return driver.findElement(supportHoursBtnLocator);
    }

    public void specifySupportHours(String workingHrs) {
        driver.findElement(workingHrsFieldLocator).clear();
        driver.findElement(workingHrsFieldLocator).sendKeys(workingHrs);
    }

    public void specifySupportStartTime(String starTime) {
        //driver.findElement(clearTimeLocator).click();
        driver.findElement(startingTimeFieldLocator).clear();
        driver.findElement(startingTimeFieldLocator).sendKeys(starTime);
    }

    public void selectWorkingDay(String workingDayIndex) {
        //User should enter index from 1 to 7
        driver.findElement(By.xpath("//tr//td//div[" + workingDayIndex + "]//input[@class='ant-checkbox-input ng-untouched ng-pristine ng-valid']")).click();
    }

    public WebElement saveSupportHoursButton() {
        return driver.findElement(okBtnLocator);
    }

    public WebElement closeSupportHoursPopupButton() {
        return driver.findElement(cancelPopup_BtnLocator);
    }


    public WebElement saveButton() {
        return driver.findElement(saveBtnLocator);
    }

    public WebElement cancelButton() {
        return driver.findElement(cancelBtnLocator);
    }

}
