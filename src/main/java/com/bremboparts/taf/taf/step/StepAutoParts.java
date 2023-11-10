package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.HomePage;
import com.bremboparts.taf.taf.util.Util;

public class StepAutoParts {
    public static void openHomePageAndSendKeysAutoParameters(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.sendKeysBrandModelTypeParameters();
        homePage.clickButtonSearch();
        Util.waitFor(5);
    }
}
