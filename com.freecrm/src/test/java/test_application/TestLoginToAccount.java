package test_application;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.LoginIntro;

public class TestLoginToAccount extends BasePage {

   @Test (dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "loginCredentials")
   public void testLogin(String email, String password){
      LoginIntro loginIntro = new LoginIntro();
      loginIntro.navigateToLoginPage();
      loginIntro.sendKeysEmailAdd(email);
      loginIntro.sendKeysPassword(password);
      loginIntro.clickLoginButton();
      Assert.assertTrue(isElementVisible(loginIntro.searchBar));
   }

}
