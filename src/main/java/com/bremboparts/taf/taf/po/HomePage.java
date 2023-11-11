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

public class HomePage {
    private WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    JavascriptExecutor js;
    @FindBy(xpath = "//div[@id='app']/footer/div/div[2]/span[1]")
    private WebElement textCopyrightWebElement;
    @FindBy(xpath = "//nav[@data-type='nav']/div[5]/a")
    private WebElement buttonSupportWebElement;
    @FindBy(xpath = "//div[@data-type='account']")
    private WebElement buttonAccauntWebElement;
    @FindBy(xpath = "//button[text()='Accept all']")
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
    @FindBy(xpath = "//input[@id='CCmCode']")
    private WebElement inputDisplacementWebElement;
    @FindBy(xpath = "//input[@id='YearCode']")
    private WebElement inputYeartWebElement;
    @FindBy(xpath = "//div[@class='row search-result'][3]/span[1]")
    private WebElement selectTypeNameModelWebElement;
    @FindBy(xpath = "//button[@id='SubmitType']")
    private WebElement buttonSearchWebElement;
    @FindBy(xpath = "//div[@class='list-data']/div[4]/span[1]")
    protected static WebElement selectTypeForBrandAndModel;
    @FindBy(xpath = "//span[text()='HONDA']")
    protected static WebElement selectHondaBrandWebElement;
    @FindBy(xpath = "//span[text()='CIVIC VI Coupe (EJ, EM1) ']")
    protected static WebElement selectModelForHondaWebElement;
    @FindBy(xpath = "//span[text()='HONDA']")
    protected static WebElement selectHondaMotoBrandWebElement;
    @FindBy(xpath = "//span[text()='CR E']")
    protected static WebElement selectHondaMotoModelWebElement;
    @FindBy(xpath = "//div[@class='item search-result']/span")
    protected static WebElement selectHondaMotoDisplacementWebElement;
    @FindBy(xpath = "//span[@class='voice'][starts-with(text(),'2001')]")
    protected static WebElement selectHondaMotoYearWebElement;
    @FindBy(xpath = "//button[@aria-label='Bike']")
    private WebElement buttonMotoWebElement;


    public HomePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.bremboparts.com/europe/en");
        log.info("open Home page Brembo Parts");
        clickButtonAcceptCookie();
        clickButtonCurrentRegion();
        log.info("cookie and region window is closed");

    }

    public void chooseBrandAndModelAndType(WebElement brand, WebElement model, WebElement type) {
        inputBrandCodeWebElement.click();
        Util.waitFor(10);
        Util.waitAndClick(brand);
        inputModelCodeWebElement.click();
        Util.waitAndClick(model);
        inputTypeCodeWebElement.click();
        Util.waitAndClick(type);
        log.info("brand, model, type:  written down");
    }

    public void choseBrandAndModelAndDisplacementAndYear(WebElement brand, WebElement model, WebElement displacement, WebElement year){
        inputBrandCodeWebElement.click();
        Util.waitAndClick(brand);
        inputModelCodeWebElement.click();
        Util.waitAndClick(model);
        inputDisplacementWebElement.click();
        Util.waitAndClick(displacement);
        inputYeartWebElement.click();
        Util.waitAndClick(year);
        log.info("brand, model, type, displacement, year for moto:  written down");

    }

    public void clickButtonSearch() {
        buttonSearchWebElement.click();
        log.info("search button pressed");
    }

    public String geTextCopyrightHomePage() {
        return textCopyrightWebElement.getText();
    }

    public void clickButtonAcceptCookie() {
        Util.waitAndClick(buttonAcceptCookieWebElement);
        log.info("the cookie window is closed");
    }

    public void clickButtonCurrentRegion() {
        Util.waitAndClick(buttonCloseCurrentRegionWebElement);
        log.info("the country selection window is closed");
    }

    public void clickButtonTurnOffNotifications() {
        Util.waitAndClick(buttonTurnOffNotificationsWebElement);
        log.info("the notifications window is closed");
    }

    public void clickButtonMoto(){
        buttonMotoWebElement.click();
        log.info("bike button pressed");
    }

    public void clickButtonSupport(){
        Util.waitAndClick(buttonSupportWebElement);
        log.info("support button pressed");
    }

    public void clickButtonAccount(){
        Util.waitAndClick(buttonAccauntWebElement);
        log.info("account button pressed");
    }
}
