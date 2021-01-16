package com.study.task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginLogoutTestPO extends BaseTest{

    @Test
    public void LoginLogoutTest() {
        driver.get("http://tut.by");
        MainPagePO mainPagePO=new MainPagePO(driver);
        mainPagePO.goLoginPage();
        LoginPagePO loginPagePO=new LoginPagePO(driver);
        Utils utils=new Utils();
        utils.takeScreen(driver);
        assertEquals(loginPagePO.getHeadingLoginPage(), "Войти как пользователь");
        loginPagePO.loginWithInvalidCreds();
        assertEquals(loginPagePO.getHeadingLogin(), "Selenium Test");
        mainPagePO.logOut();
        assertEquals(mainPagePO.getHeadingLogout(), "Войти");
    }


}
