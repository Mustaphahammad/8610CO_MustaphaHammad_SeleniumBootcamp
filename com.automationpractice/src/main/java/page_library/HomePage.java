package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id ='shopping_cart_container']/a")
    public static WebElement shoppingCart;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    public static List<WebElement> addToCartList;

    @FindBy(css = "#react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(css = "#logout_sidebar_link")
    public WebElement logoutButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCart addItemsToCart(int itemNum) {
        WebElement element;
        if (itemNum < addToCartList.size()) {
            element = addToCartList.get(itemNum);
            clickOnElement(element);
        } else {
            System.out.println("item number is invalid !!!");
        }
        clickShoppingCart();

        return new ShoppingCart();
    }

    public void clickShoppingCart() {
        clickOnElement(shoppingCart);
    }


    public LoginIntro clickLogoutButton() {
        clickOnElement(menuButton);
        clickOnElement(logoutButton);
        return new LoginIntro();
    }


}
