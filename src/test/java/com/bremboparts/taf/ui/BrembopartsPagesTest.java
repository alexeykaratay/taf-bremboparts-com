package com.bremboparts.taf.ui;

import com.bremboparts.taf.taf.step.StepAutoParts;
import com.bremboparts.taf.taf.step.StepOpenHomePage;
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
    public void TestAuto() throws InterruptedException {
        StepAutoParts.openHomePageAndSendKeysAutoParameters();
        Thread.sleep(5000);
    }




}
