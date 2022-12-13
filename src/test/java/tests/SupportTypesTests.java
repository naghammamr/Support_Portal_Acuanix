package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Menu;
import pages.SupportTypesPage;

public class SupportTypesTests extends BaseTests {

    SupportTypesPage supportTypes;
    Menu menu;
    LoginPage loginPage;

    @Test(priority = 1)
    public void superAdminCanLoginToThePortal() {
        loginPage = new LoginPage(driver);
        loginPage.setLoginData("sadmin@acuanix.com", "P@ssw0rd");
        loginPage.clickLoginButton().click();
        System.out.println(loginPage.clickLoginButton().getText());
    }

    @Test(dependsOnMethods = "superAdminCanLoginToThePortal")
    public void userCanNavigateToSupportTypes() {
        menu = new Menu(driver);
        menu.getConfigurationsMenuHeaderLocator().click();
        menu.getSupportTypeMenuLocator().click();
    }

    String workingHrs = "1";
    @Test(dependsOnMethods = "userCanNavigateToSupportTypes")
    public void addNewSupportType() {
        supportTypes = new SupportTypesPage(driver);
        supportTypes.addButton().click();
        supportTypes.specifyName("Testing");
        supportTypes.specifyDescription("anyyy");
        supportTypes.supportHoursPopupButton().click();
        supportTypes.specifySupportHours(workingHrs);
        //supportTypes.specifySupportStartTime("01:20");
        supportTypes.selectWorkingDay("2");
        supportTypes.selectWorkingDay("5");
        supportTypes.saveSupportHoursButton().click();
        supportTypes.selectIDPattern_TEXT("TEXT");
        supportTypes.saveButton().click();
    }
}
