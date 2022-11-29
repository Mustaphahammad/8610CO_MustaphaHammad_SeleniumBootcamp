package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'1')]")
    public static WebElement shoppingCartQty;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeItemButton;

    @FindBy(css = "#checkout")
    public WebElement checkoutButton;

    public ShoppingCart(){
        PageFactory.initElements(driver,this);
    }

    public void removeItemFromCart(){
        clickOnElement(removeItemButton);
    }
    public CheckoutPage clickCheckout(){
        clickOnElement(checkoutButton);
        return new CheckoutPage();
    }

}
