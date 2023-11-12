package com.bremboparts.taf.ui.test;

import com.bremboparts.taf.taf.driver.Driver;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    @AfterEach
    public void driverClose() {
        Driver.quitDriver();
    }
}
