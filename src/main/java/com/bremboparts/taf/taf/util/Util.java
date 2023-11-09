package com.bremboparts.taf.taf.util;

import com.bremboparts.taf.taf.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Util {
    public static void clickAndWaitElement(WebElement element) {
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
}
