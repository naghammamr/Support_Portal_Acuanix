package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Menu;
import pages.PrioritiesPage;

public class T_PriorityTest extends BaseTests {

    Menu menu;
    PrioritiesPage prioritiesPage;

//    LoginPage loginPage;
//
//    @Test(priority = 1)
//    public void superAdminCanLoginToThePortal()
//    {
//        loginPage = new LoginPage(driver);
//        loginPage.setLoginData("sadmin@acuanix.com","P@ssw0rd");
//        loginPage.clickLoginButton().click();
//        System.out.println(loginPage.clickLoginButton().getText());
//    }

    @Test//(dependsOnMethods = "superAdminCanLoginToThePortal")
    public void userCanNavigateToTicketPriority() {
        menu = new Menu(driver);
        menu.getConfigurationsMenuHeaderLocator().click();
        menu.getTicketPriorityMenuLocator().click();
    }

    @Test//(dependsOnMethods = "userCanNavigateToTicketPriority")
    public void userCanAddNewPriority() {
        prioritiesPage = new PrioritiesPage(driver);

        prioritiesPage.addButton().click();
        prioritiesPage.selectColor();
//        prioritiesPage.selectColor2().click();
//        prioritiesPage.selectColor2().sendKeys("67");

    }

}
