package com.bremboparts.taf.ui;

import com.bremboparts.taf.taf.po.CatalogAutoPage;
import com.bremboparts.taf.taf.po.CatalogMotoPage;
import com.bremboparts.taf.taf.po.SearchResultPage;
import com.bremboparts.taf.taf.step.StepAutoParts;
import com.bremboparts.taf.taf.step.StepMotoParts;
import com.bremboparts.taf.taf.step.StepOpenHomePage;
import com.bremboparts.taf.taf.step.StepSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrembopartsPagesTest extends BaseTest {

    @DisplayName("Open home page")
    @Test
    public void testOpenHomePage() {
        Assertions.assertTrue(StepOpenHomePage.openHomePageAndGetCopyrightText().
                contains("© BREMBO S.P.A."), "Copyright text does not match!");
    }

    @DisplayName("Search brake disk for auto")
    @Test
    public void testAuto() {
        StepAutoParts.openHomePageAndSendKeysAutoParametersAndClickButtonPrimeAndClickButtonCompabilible();
        boolean containsExpectedText =new CatalogAutoPage().getSearchResult().stream()
                .anyMatch(element -> element.getText().contains("CIVIC VI Coupe (EJ, EM1)"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Search brake disk for moto")
    @Test
    public void testMoto(){
        StepMotoParts.openHomePageAndClickButtonMotoAndChoseBrandAndModelAndDisplacementAndYearAndClickButtonSearchAndClickButtonBrakeDiskMotoFrontInfoAndClickButtonCompatibleMotoAndButtonCompatibleMotoHonda();
        boolean containsExpectedText =new CatalogMotoPage().getSearchResultMoto().stream()
                .anyMatch(element -> element.getText().contains("CR E"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Search in support")
    @Test
    public void testSupportSearch(){
        StepSupport.openHomePageAndClickSupportButtonAndSendKeysSearchLineAndClickButtonSearch();
        boolean containsExpectedText = new SearchResultPage().getSearchResultFromSupport().stream()
                .anyMatch(element -> element.getText().contains("Homologation certificates for Brembo"));
        Assertions.assertTrue(containsExpectedText,"Element with text not found");
    }

}
