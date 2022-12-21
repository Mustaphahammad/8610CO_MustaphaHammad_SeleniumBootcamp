package test_app;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_libray.HomePage;
import page_libray.LoginPage;
import page_libray.MyAccountPage;

public class TestLoginLogout extends BasePage {

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "LoginCredentials")
    public void testLoginToAccount(String email, String password){
        HomePage homePage = new HomePage();
        MyAccountPage accountPage = homePage.clickMyAccountButton();
        LoginPage loginPage = accountPage.navigateToLoginPage();
        loginPage.loginToAccount(email,password);
        webDriverWait.until(ExpectedConditions.visibilityOf(homePage.myAccountButton));
        String expText = "Hi Mustapha";
        String actText = homePage.myAccountButton.getText();
        Assert.assertEquals(actText,expText);
    }

    @Test(dataProviderClass = data_providers.DataProviderClass.class,dataProvider = "LoginCredentials")
    public void testLogoutFromMyAccount(String email, String password){
        HomePage homePage = new HomePage();
        MyAccountPage accountPage = homePage.clickMyAccountButton();
        LoginPage loginPage = accountPage.navigateToLoginPage();
        loginPage.loginToAccount(email,password);
        webDriverWait.until(ExpectedConditions.visibilityOf(homePage.myAccountButton));
        homePage.clickMyAccountButton();
        loginPage.clickLogoutButton();
        String expText = "My Account";
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(homePage.myAccountButton,expText));
        String actText = homePage.myAccountButton.getText();
        Assert.assertEquals(actText,expText);
    }

}
