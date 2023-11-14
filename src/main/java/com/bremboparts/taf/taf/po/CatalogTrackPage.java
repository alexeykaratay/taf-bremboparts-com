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

import java.util.List;

public class CatalogTrackPage{
    WebDriver driver;
    JavascriptExecutor js;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//div[@class='application-detail scrollbar']/div")
    private List<WebElement> listBrakeDiskForTracWebElement;
    @FindBy(xpath = "//span[@class='label'][text()='Prime']")
    private WebElement buttonBrakeDiskFrontInfoWebelement;

    public CatalogTrackPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void clickButtonBrakeDiskTrackInfo() {
        Util.waitWebElement(buttonBrakeDiskFrontInfoWebelement);
        js.executeScript("document.querySelector(\"#ResultList > div.products-group > div.group-list > div > div > button.codes-list > div > div > div.code\").click();");
        log.info("brake disk front Info button pressed");
    }
    public void clickButtonCompatibleTrackList(){
        new CatalogAutoPage().ClickButtonCompatibleAuto();
    }

    public List<WebElement> getSearchResultTrack(){
        List<WebElement> elements = Util.WaitElementCustom(listBrakeDiskForTracWebElement);
        log.info("list created result compatible auto:" + Util.getListString(listBrakeDiskForTracWebElement));
        return elements;
    }


}
