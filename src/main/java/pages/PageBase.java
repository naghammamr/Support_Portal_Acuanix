package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
    private WebDriver driver;
    private JavascriptExecutor jse;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

//    public void scrollToBottom() {
//        //WebElement tableElement = driver.findElement(lastIDLocator);
//        //object casting
//        String script = "arguments[0].scrollIntoView();";
//        ((JavascriptExecutor)driver).executeScript(script,tableElement);
//    }

    public void scrolling() {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void scrollToParagraph(int index) {
        String script = "window.ScrollTo(0, document.body.scrollHeight)";
    }

}