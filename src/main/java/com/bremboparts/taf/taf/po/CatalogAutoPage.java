package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CatalogAutoPage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//span[@class='label'][text()='Prime']")
    private WebElement buttonBrakeDiskFrontInfoWebelement;
    @FindBy(xpath = "//div[@class='button']")
    private List<WebElement> buttonCompatibleAutoListWebElement;

    @FindBy(xpath = "//div[@id='ResultList']/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div")
    private List<WebElement> listResultCompatibleAuto;
    @FindBy(xpath = "//*[@id='ResultList']/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[13]/div[1]")
    private WebElement test;

    public CatalogAutoPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void clickButtonBrakeDiskFrontInfo() {
        Util.waitAndClick(buttonBrakeDiskFrontInfoWebelement);
        log.info("brake disk front Info button pressed");
    }

    public void ClickButtonCompatibleAuto() {
        Util.clickAndWaitElementCustom(buttonCompatibleAutoListWebElement.get(61));
        log.info("compatible button pressed");
    }

    public List<WebElement> getSearchResult() {
        List<WebElement> elements = Util.WaitElementCustom(listResultCompatibleAuto);
        log.info("list created result compatible auto:" + Util.getListString(listResultCompatibleAuto));
        return elements;
    }
}
