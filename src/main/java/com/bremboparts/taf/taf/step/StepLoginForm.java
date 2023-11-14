package com.bremboparts.taf.taf.step;

import com.bremboparts.taf.taf.po.HomePage;
import com.bremboparts.taf.taf.po.LoginFormPage;
import com.github.javafaker.Faker;

public class StepLoginForm {
    private static Faker faker = new Faker();

    public static void openHomePageAndClickButtonAccountAndSendKeysUserNameAndSendKeysPasswordAndClickButtonLogIn() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonAccount();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.sendKeysUserName(faker.internet().emailAddress());
        loginFormPage.sendKeysPassword(faker.internet().password());
        loginFormPage.clickButtonLogIn();
    }

    public static void openHomePageAndClickButtonAccountAndSendKeysPasswordAndClickButtonLogIn() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonAccount();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.sendKeysPassword(faker.internet().password());
        loginFormPage.clickButtonLogIn();
    }

    public static void openHomePageAndClickButtonAccountAndSendKeysUserNameAndClickButtonLogIn() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonAccount();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.sendKeysUserName(faker.internet().emailAddress());
        loginFormPage.clickButtonLogIn();
    }

    public static void openHomePageAndClickButtonAccountAndClickButtonLogIn() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
        homePage.clickButtonAccount();
        LoginFormPage loginFormPage = new LoginFormPage();
        loginFormPage.sendKeysUserName("");
        loginFormPage.sendKeysPassword("");
        loginFormPage.clickButtonLogIn();
    }
}
