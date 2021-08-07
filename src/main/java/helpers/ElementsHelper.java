package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsHelper {
    protected WebDriver driver;

    public ElementsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnVisibleAndClickableElement(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(element)));
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(element)));
            driver.findElement(element).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Web element is not visible or clickable within timeout:" + element + "Time" + timeout, e);
        } catch (WebDriverException e) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
            driver.findElement(element).click();
        }
    }
}
