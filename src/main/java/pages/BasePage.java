package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class BasePage {
    WebDriver driver;
    WebDriverWait defaultWait;
    Actions actionDriver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        defaultWait = new WebDriverWait(driver, 10);
        actionDriver = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        System.out.println("klikam w element + " + element.getText());
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        System.out.println("Wpisuję: " + text);
        element.sendKeys(text);
    }

    public void elementToBeClickable(WebElement element) {
        defaultWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement elementToBeClickable(By by) {
        return defaultWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void visibilityOf(WebElement element) {
        defaultWait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement visibilityOf(By by) {
        return defaultWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void hoverOverElement(WebElement element) {
        actionDriver.moveToElement(element).perform();
    }

    WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(elements.size() - 1);
        return elements.get(randomNumber);
    }

    public boolean isPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
