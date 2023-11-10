package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//div[@id='app']/footer/div/div[2]/span[1]")
    private WebElement textCopyrightWebElement;
    @FindBy(xpath = "//button[text()='Принять все']")
    private WebElement buttonAcceptCookieWebElement;
    @FindBy(xpath = "//div[@class='actions']/button[1]")
    private WebElement buttonCloseCurrentRegionWebElement;
    @FindBy(xpath = "//div[@class='actions']/div[2]/button")
    private WebElement buttonTurnOffNotificationsWebElement;
    @FindBy(xpath = "//input[@id='BrandCode']")
    private WebElement inputBrandCodeWebElement;
    @FindBy(xpath = "//input[@id='ModelCode']")
    private WebElement inputModelCodeWebElement;
    @FindBy(xpath = "//input[@id='TypeCode']")
    private WebElement inputTypeCodeWebElement;
    @FindBy(xpath = "//div[@class='row search-result'][3]/span[1]")
    private WebElement selectTypeNameModelWebElement;
    @FindBy(xpath = "//button[@id='SubmitType']")
    private WebElement buttonSearchWebElement;


    public HomePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.bremboparts.com/");
        log.info("open Home page Brembo Parts");
        clickButtonAcceptCookie();
        clickButtonCurrentRegion();

    }

    public void sendKeysBrandModelTypeParameters() {

        sendKeysBrandAndModelAndType("HONDA", "CIVIC VI Coupe (EJ, EM1) 03.96 - 12.00", "1.6 i Vtec (EM1) (92 kW/125 CV) 03.96 - 03.00");
        log.info("type name written down");

    }

    public void sendKeysBrandAndModelAndType(String brand, String model, String type) {
        inputBrandCodeWebElement.sendKeys(brand);
        Util.sendKeysAndWaitElement(inputModelCodeWebElement, model);
        Util.sendKeysAndWaitElement(inputTypeCodeWebElement, type);
        log.info("brand, model, type:  written down");
    }

    public void clickButtonSearch() {
        Util.waitFor(0.36);
        buttonSearchWebElement.click();
    }

    public String geTextCopyrightHomePage() {
        return textCopyrightWebElement.getText();
    }

    public void clickButtonAcceptCookie() {
        buttonAcceptCookieWebElement.click();
        log.info("the cookie window is closed");
    }

    public void clickButtonCurrentRegion() {
        buttonCloseCurrentRegionWebElement.click();
        log.info("the country selection window is closed");
    }

    public void clickButtonTurnOffNotifications() {
        try {
            Util.clickAndWaitElement(buttonTurnOffNotificationsWebElement);
            log.info("notification window is closed");
        }catch (Exception e){
            log.info("notification window is not opened");
        }
    }
}
