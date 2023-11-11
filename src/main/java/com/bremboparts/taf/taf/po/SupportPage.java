package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupportPage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    JavascriptExecutor js;
    @FindBy(xpath = "//div[@data-type='input']")
    private WebElement inputSearchLineWebElement;
    @FindBy(xpath = "//button[@data-bind='click: searchList']")
    private WebElement buttonSearchWebElement;

    public SupportPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void sendKeysSearchLine(String keys) {
        js.executeScript("document.querySelector('#SupportSearch > div > div > div > div:nth-child(1) > input').value = '" + keys + "'");
        inputSearchLineWebElement.click();
        log.info("send keys parameters");
    }

    public void clickButtonSearch() {
        buttonSearchWebElement.click();
        log.info("search button pressed");
    }
}
