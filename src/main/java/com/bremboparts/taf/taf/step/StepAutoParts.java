package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.CatalogAutoPage;
import com.bremboparts.taf.taf.po.HomePage;

public class StepAutoParts extends HomePage {
    public static void openHomePageAndSendKeysAutoParametersAndClickButtonPrimeAndClickButtonCompabilible() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.chooseBrandAndModelAndType(selectHondaBrandWebElement, selectModelForHondaWebElement, selectTypeForBrandAndModel);
        homePage.clickButtonSearch();
        CatalogAutoPage catalogAutoPage = new CatalogAutoPage();
        catalogAutoPage.clickButtonBrakeDiskFrontInfo();
        catalogAutoPage.ClickButtonCompatibleAuto();
    }
}
