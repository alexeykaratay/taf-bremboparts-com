package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.HomePage;

public class StepAutoParts {
    public static void openHomePageAndSendKeysAutoParameters(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.sendKeysBrandModelTypeParameters();
    }
}
