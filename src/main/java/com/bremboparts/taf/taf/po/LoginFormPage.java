package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class LoginFormPage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//input[@id='UserName']")
    private WebElement inputUserNameWebElement;
    @FindBy(xpath = "//input[@id='Password']")
    private WebElement inputPasswordWebElement;
    @FindBy(xpath = "//button[@class='button']")
    private List<WebElement> buttonLogInWebElement;
    @FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
    private WebElement textErrorMessageWebElement;
    @FindBy(xpath = "//div[@class='validation-summary-errors']/ul/li")
    private List<WebElement> textErrorMessageWebElementList;


    public LoginFormPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void sendKeysUserName(String keys) {
        Util.waitAndSendKeys(inputUserNameWebElement, keys);
        log.info("user name send keys with random");
    }

    public void sendKeysPassword(String keys) {
        Util.waitAndSendKeys(inputPasswordWebElement, keys);
        log.info("password send keys with random");
    }

    public void clickButtonLogIn() {
        Util.waitAndClick(buttonLogInWebElement.get(0));
        log.info(" button Log In pressed");
    }

    public String getErrorMessage() {
        String element = Util.waitAndGetText(textErrorMessageWebElement);
        log.info("error message created");
        return element;
    }

    public String getErrorMessageString() {
        Util.WaitElementCustom(textErrorMessageWebElementList);
        List<String> stringList = new ArrayList<>();
        for (WebElement element : textErrorMessageWebElementList) {
            stringList.add(element.getText());
        }
        StringBuilder result = new StringBuilder();
        for (String str : stringList) {
            result.append(str).append(" ");
        }
        log.info("error message created: " + stringList);
        return result.toString().trim();
    }
}
