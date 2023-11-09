package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//div[@id='app']/footer/div/div[2]/span[1]")
    private WebElement textCopyrightWebElement;
    @FindBy(xpath = "//button[text()='Принять все']")
    private WebElement buttonAcceptCookieWebElement;
    @FindBy(xpath = "//button[@aria-label='Confirm and close']")
    private WebElement buttonCloseCurrentRegionWebElement;
    @FindBy(xpath = "//div[@class='actions']/div[2]/button")
    private WebElement buttonTurnOffNotificationsWebElement;
    @FindBy(xpath = "//input[@id='BrandCode']")
    private WebElement inputBrandCodeWebElement;
    @FindBy (xpath = "//input[@id='ModelCode']")
    private WebElement inputModelCodeWebElement;
    @FindBy (xpath = "//input[@id='TypeCode']")
    private WebElement inputTypeCodeWebElement;
    @FindBy(xpath = "/div[@class='row search-result'][3]/span[1]")
    private WebElement selectTypeNameModelWebElement;


    public HomePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.bremboparts.com/");
        log.info("open Home page Brembo Parts");
        clickButtonAcceptCookie();
        clickButtonCurrentRegion();
        clickButtonTurnOffNotifications();
    }

    public void sendKeysBrandModelTypeParameters(){
        sendKeysBrandAndModel("HONDA", "CIVIC VI Coupe (EJ, EM1) 03.96 - 12.00");
        try {
            inputTypeCodeWebElement.click();
              inputTypeCodeWebElement.click();
              selectTypeNameModelWebElement.click();

            log.info("type name written down");
        } catch (Exception e){
            log.error("type name not written down");
        }

    }

    public void sendKeysBrandAndModel(String brand, String model ){
        try {
            inputBrandCodeWebElement.sendKeys(brand);
            inputModelCodeWebElement.click();
            inputModelCodeWebElement.sendKeys(model);

            log.info("brand name written down");
        } catch (Exception e){
            log.error("brand name not written down");
        }
    }

    public String geTextCopyrightHomePage() {
        return textCopyrightWebElement.getText();
    }

    public void clickButtonAcceptCookie() {
        try {
            buttonAcceptCookieWebElement.click();
            log.info("the cookie window is closed");
        } catch (Exception e) {
            log.error("The cookie window is not closed");
        }
    }

    public void clickButtonCurrentRegion() {
        try {
            Util.clickAndWaitElement(buttonCloseCurrentRegionWebElement);
            log.info("the country selection window is closed");
        } catch (Exception e){
            log.error("the country selection window is not closed");
        }
    }

    public void clickButtonTurnOffNotifications() {
        try {
            Util.clickAndWaitElement(buttonTurnOffNotificationsWebElement);
            log.info("notification window is closed");
        } catch (Exception e){
            log.error("notification window is not closed");
        }
    }
}
