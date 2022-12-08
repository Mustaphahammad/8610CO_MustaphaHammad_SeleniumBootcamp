package test_application;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.LoginIntro;

public class TestLoginToAccount extends BasePage {

   @Test (dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "loginCredentials")
   public void testLogin(String email, String password){
      LoginIntro loginIntro = new LoginIntro();
      loginIntro.loginToAccount(email, password);
      Assert.assertTrue(isElementVisible(loginIntro.searchBar));
   }

   @Test (dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "loginCredentials")
   public void testLogout(String email,String password){
      LoginIntro loginIntro = new LoginIntro();
      loginIntro.loginToAccount(email, password)
              .clickLogoutButton(5);
      Assert.assertTrue(isElementVisible(loginIntro.loginButton));
   }

}
