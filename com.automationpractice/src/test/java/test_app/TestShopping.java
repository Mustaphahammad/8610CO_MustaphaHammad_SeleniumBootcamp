package test_app;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_library.CheckoutPage;
import page_library.LoginIntro;
import page_library.ShoppingCart;

public class TestShopping extends BasePage {

    @Test(dataProviderClass = data_providers.DataProviders.class, dataProvider = "loginCredentials")
    public void testAddItemToCart(String username, String password) {
        LoginIntro loginIntro = new LoginIntro();
        loginIntro.loginToMyAccount(username,password).addItemsToCart(0);
        Assert.assertTrue(isElementVisible(ShoppingCart.shoppingCartQty));
    }

    @Test(dataProviderClass = data_providers.DataProviders.class, dataProvider = "loginCredentials")
    public void testRemovingItemFromCart(String userName, String password){
        LoginIntro loginIntro = new LoginIntro();
        loginIntro.loginToMyAccount(userName,password)
                .addItemsToCart(3)
                .removeItemFromCart();
        Assert.assertFalse(isElementVisible(ShoppingCart.shoppingCartQty));
    }


    @Test(dataProviderClass = data_providers.DataProviders.class, dataProvider = "loginCredentials")
    public void testCheckoutItem(String username, String password){
        LoginIntro loginIntro = new LoginIntro();
        loginIntro.loginToMyAccount(username,password)
                .addItemsToCart(3)
                .clickCheckout()
                .checkoutFillingForm();
        Assert.assertTrue(isElementVisible(CheckoutPage.thankYouMessage));
    }







}
