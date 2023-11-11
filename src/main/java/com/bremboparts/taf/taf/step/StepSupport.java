package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.HomePage;
import com.bremboparts.taf.taf.po.SupportPage;
import com.bremboparts.taf.taf.util.Util;

import java.nio.file.Watchable;

public class StepSupport {
    public static void openHomePageAndClickSupportButtonAndSendKeysSearchLineAndClickButtonSearch(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonSupport();
        SupportPage supportPage = new SupportPage();
        supportPage.sendKeysSearchLine("Homologation certificates for Brembo");
        supportPage.clickButtonSearch();
    }
}
