package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Menu {

    private WebDriver driver;

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    //Configurations Menu Header
    private By configurationsMenuHeaderLocator = By.xpath("//span[@class='ng-star-inserted'][contains(.,'Configurations')]");
    private By TicketPriorityMenuLocator = By.id("Ticket Priority");
    private By SupportTypesMenuLocator = By.id("Support Types");


    public WebElement getConfigurationsMenuHeaderLocator() {
        return driver.findElement(configurationsMenuHeaderLocator);
    }

    public WebElement getTicketPriorityMenuLocator() {
        return driver.findElement(TicketPriorityMenuLocator);
    }

    public WebElement getSupportTypeMenuLocator() {
        return driver.findElement(SupportTypesMenuLocator);
    }
}
