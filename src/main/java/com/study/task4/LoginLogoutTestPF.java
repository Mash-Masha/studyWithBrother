package com.study.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginLogoutTestPF extends BaseTest {
    public Utils utils;


    @Test
    public void LoginLogoutTest() {
        driver.get("http://tut.by");
        MainPagePF mainPagePF=new MainPagePF(driver);
        mainPagePF.goLoginPage();
        LoginPagePF loginPagePF=new LoginPagePF(driver);
        utils=new Utils();
        utils.takeScreen(driver);
        assertEquals(loginPagePF.getHeadingLoginPage(), "Войти как пользователь");
        loginPagePF.loginWithInvalidCreds("seleniumtests@tut.by", "123456789zxcvbn");
        assertEquals(loginPagePF.getHeadingLogin(), "Selenium Test");
        mainPagePF.logOut();
    }


}

