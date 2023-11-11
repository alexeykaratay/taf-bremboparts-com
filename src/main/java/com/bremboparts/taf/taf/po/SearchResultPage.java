package com.bremboparts.taf.taf.po;

import com.bremboparts.taf.taf.driver.Driver;
import com.bremboparts.taf.taf.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    private static final Logger log = LogManager.getLogger();
    @FindBy(xpath = "//h2[@class='title mrg']")
    private List <WebElement> blocksSearchResultWebElement;

    public SearchResultPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getSearchResultFromSupport(){
        return Util.WaitElementCustom(blocksSearchResultWebElement);
    }
}
