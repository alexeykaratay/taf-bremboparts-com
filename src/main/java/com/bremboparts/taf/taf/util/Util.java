package com.bremboparts.taf.taf.util;

import com.bremboparts.taf.taf.driver.Driver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static void clickAndWaitElementCustom(WebElement element) {
        Wait<WebDriver> wait =
                new FluentWait<>(Driver.getDriver())
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    element.click();
                    return true;
                });
    }

    public static void waitAndClick(WebElement webElement) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement))
                .click();
    }
    public static void waitAndSendKeys(WebElement webElement, String keys) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement))
                .sendKeys(keys);
    }

    public static void waitFor(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> WaitElementCustom(List<WebElement> element) {
        Util.waitFor(1.2);
      new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElements(element));
      return element;
    }

    public static List<String> getListString(List<WebElement> elements){
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            String elementText = element.getText();
            textList.add(elementText);
        }
        return textList;
    }
}