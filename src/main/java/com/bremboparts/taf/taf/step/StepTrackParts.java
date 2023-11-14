package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.CatalogTrackPage;
import com.bremboparts.taf.taf.po.HomePage;

public class StepTrackParts extends HomePage {
    public static void openHomePageAndClickTrackButtonAndChooseBrandAndModelAndTypeAndClickButtonSearchAndClickButtonBrakeDiskTrackInfoAndClickButtonCompatibleTrackList(){
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonTrack();
        homePage.chooseBrandAndModelAndType(selectMackTrackBrandWebElement,selectMackTrackModelWebElement,selectMackTrackTypeWebElement);
        homePage.clickButtonSearch();
        CatalogTrackPage catalogTrackPage = new CatalogTrackPage();
        catalogTrackPage.clickButtonBrakeDiskTrackInfo();
        catalogTrackPage.clickButtonCompatibleTrackList();
    }
}
