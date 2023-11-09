package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.HomePage;

public class StepOpenHomePage {
    public static String openHomePageAndGetCopyrightText() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        return homePage.geTextCopyrightHomePage();
    }
}
