package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogMotoPage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//span[@class='label'][text()='Serie Oro fixed']")
    private WebElement buttonBrakeDiskMotoFrontInfoWebelement;
    @FindBy(xpath = "//div[@class='button']")
    private List<WebElement> buttonCompatibleMotoListWebElement;
    @FindBy(xpath = "//div[@class='button'][starts-with(text(),'HONDA')]")
    private WebElement buttonCompatibleMotoHondaWebElement;
    @FindBy(xpath = "//div[@class='application-detail scrollbar']/div")
    private List<WebElement> listResultCompatibleMoto;


    public CatalogMotoPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickButtonBrakeDiskMotoFrontInfo() {
        Util.waitAndClick(buttonBrakeDiskMotoFrontInfoWebelement);
        log.info("brake disk front for moto Info button pressed");
    }

    public void clickButtonCompatibleMoto() {
        Util.clickAndWaitElementCustom(buttonCompatibleMotoListWebElement.get(61));
        log.info("compatible for moto button pressed");
    }

    public List<WebElement> getSearchResultMoto() {
        List<WebElement> elements = Util.WaitElementCustom(listResultCompatibleMoto);
        log.info("list created result compatible moto:" + Util.getListString(listResultCompatibleMoto));
        return elements;
    }

    public void buttonCompatibleMotoHonda() {
        Util.waitFor(1);
        Util.clickAndWaitElementCustom(buttonCompatibleMotoHondaWebElement);
        log.info("compatible moto honda pressed");
    }







}
