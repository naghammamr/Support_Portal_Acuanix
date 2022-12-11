package tests;

import org.testng.annotations.Test;
import pages.Menu;
import pages.PrioritiesPage;

public class T_PriorityTest extends BaseTests {

    Menu menu;
    PrioritiesPage prioritiesPage;

    @Test
    public void userCanNavigateToTicketPriority() {
        menu = new Menu(driver);
        menu.getConfigurationsMenuHeaderLocator().click();
        menu.getTicketPriorityMenuLocator().click();
    }

    @Test
    public void userCanAddNewPriority() {

    }

}
