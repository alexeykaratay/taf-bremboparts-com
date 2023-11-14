package com.bremboparts.taf.ui.test;

import com.bremboparts.taf.taf.po.*;
import com.bremboparts.taf.taf.step.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrembopartsUiTest extends BaseTest {

    @DisplayName("Test UI open home page")
    @Test
    public void testOpenHomePage() {
        Assertions.assertTrue(StepOpenHomePage.openHomePageAndGetCopyrightText().
                contains("© BREMBO S.P.A."), "Copyright text does not match!");
    }

    @DisplayName("Test UI search brake disk for auto")
    @Test
    public void testAuto() {
        StepAutoParts
                .openHomePageAndSendKeysAutoParametersAndClickButtonPrimeAndClickButtonCompabilible();
        boolean containsExpectedText = new CatalogAutoPage().getSearchResult().stream()
                .anyMatch(element -> element.getText().contains("CIVIC VI Coupe (EJ, EM1)"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Test UI search brake disk for auto")
    @Test
    public void testTrack() {
        StepTrackParts
                .openHomePageAndClickTrackButtonAndChooseBrandAndModelAndTypeAndClickButtonSearchAndClickButtonBrakeDiskTrackInfoAndClickButtonCompatibleTrackList();
        boolean containsExpectedText = new CatalogTrackPage().getSearchResultTrack().stream()
                .anyMatch(element -> element.getText().contains("Midlum"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Test UI search brake disk for moto")
    @Test
    public void testMoto() {
        StepMotoParts
                .openHomePageAndClickButtonMotoAndChoseBrandAndModelAndDisplacementAndYearAndClickButtonSearchAndClickButtonBrakeDiskMotoFrontInfoAndClickButtonCompatibleMotoAndButtonCompatibleMotoHonda();
        boolean containsExpectedText = new CatalogMotoPage().getSearchResultMoto().stream()
                .anyMatch(element -> element.getText().contains("CR E"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Test UI search in support")
    @Test
    public void testSupportSearch() {
        StepSupport
                .openHomePageAndClickSupportButtonAndSendKeysSearchLineAndClickButtonSearch();
        boolean containsExpectedText = new SearchResultPage().getSearchResultFromSupport().stream()
                .anyMatch(element -> element.getText().contains("Homologation certificates for Brembo"));
        Assertions.assertTrue(containsExpectedText, "Element with text not found");
    }

    @DisplayName("Test UI login form with incorrect login and password")
    @Test
    public void testLoginFormWithIncorrectData() {
        StepLoginForm
                .openHomePageAndClickButtonAccountAndSendKeysUserNameAndSendKeysPasswordAndClickButtonLogIn();
        Assertions.assertEquals("Access data are incorrect", new LoginFormPage().getErrorMessage(), "error does not match");
    }

    @DisplayName("Test UI login form with login is empty and password is random ")
    @Test
    public void testLoginFormWithLoginIsEmptyAndRandomPassword() {
        StepLoginForm
                .openHomePageAndClickButtonAccountAndSendKeysPasswordAndClickButtonLogIn();
        Assertions.assertEquals("Email or username required", new LoginFormPage().getErrorMessage(), "error does not match");
    }

    @DisplayName("Test UI login form with login is random password is empty")
    @Test
    public void testLoginFormWithLoginIsRandomPasswordIsEmpty() {
        StepLoginForm
                .openHomePageAndClickButtonAccountAndSendKeysUserNameAndClickButtonLogIn();
        Assertions.assertEquals("Password required", new LoginFormPage().getErrorMessage(), "error does not match");
    }

    @DisplayName("Test UI login and password is empty")
    @Test
    public void testLoginFormWithLoginAndPasswordIsEmpty() {
        StepLoginForm
                .openHomePageAndClickButtonAccountAndClickButtonLogIn();
        Assertions.assertEquals("Password required Email or username required", new LoginFormPage().getErrorMessageString());
    }
}
