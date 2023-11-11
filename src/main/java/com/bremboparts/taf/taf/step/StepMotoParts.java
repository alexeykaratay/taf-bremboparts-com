package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.CatalogMotoPage;
import com.bremboparts.taf.taf.po.HomePage;

public class StepMotoParts extends HomePage {
    public static void openHomePageAndClickButtonMotoAndChoseBrandAndModelAndDisplacementAndYearAndClickButtonSearchAndClickButtonBrakeDiskMotoFrontInfoAndClickButtonCompatibleMotoAndButtonCompatibleMotoHonda(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonMoto();
        homePage.choseBrandAndModelAndDisplacementAndYear(selectHondaMotoBrandWebElement, selectHondaMotoModelWebElement, selectHondaMotoDisplacementWebElement, selectHondaMotoYearWebElement);
        homePage.clickButtonSearch();
        CatalogMotoPage catalogMotoPage = new CatalogMotoPage();
        catalogMotoPage.clickButtonBrakeDiskMotoFrontInfo();
        catalogMotoPage.clickButtonCompatibleMoto();
        catalogMotoPage.buttonCompatibleMotoHonda();


    }
}
