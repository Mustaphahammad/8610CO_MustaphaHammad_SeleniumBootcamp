package test_app;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.HomePage;
import page_library.LoginIntro;

public class TestLogin extends BasePage {
    @Test(dataProviderClass = data_providers.DataProviders.class,dataProvider = "loginCredentials")
    public void testLogin(String userName, String password){
        LoginIntro loginIntro = new LoginIntro();
        loginIntro.loginToMyAccount(userName,password);
        Assert.assertTrue(isElementVisible(HomePage.shoppingCart));
    }

    @Test(dataProviderClass = data_providers.DataProviders.class,dataProvider = "loginCredentials")
    public void testLogout(String userName,String password){
        LoginIntro loginIntro = new LoginIntro();
        loginIntro.loginToMyAccount(userName,password)
                .clickLogoutButton();
        Assert.assertTrue(isElementVisible(loginIntro.loginButton));
    }


}
