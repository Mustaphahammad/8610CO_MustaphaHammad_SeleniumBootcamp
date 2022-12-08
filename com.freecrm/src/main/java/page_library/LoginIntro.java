package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIntro extends BasePage {
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li/a[text()='Login']")
    public WebElement loginPageLink;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement myEmailAddress;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement myPassword;

    @FindBy(xpath = "//*[text() = 'Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBar;


    public LoginIntro() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        clickOnElement(loginPageLink);
    }

    public void sendKeysEmailAdd(String email) {
        isElementVisible(myEmailAddress);
        clickOnElement(myEmailAddress);
        sendKeysToElement(myEmailAddress, email);
    }

    public void sendKeysPassword(String password) {
        isElementVisible(myPassword);
        clickOnElement(myPassword);
        sendKeysToElement(myPassword, password);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }


}
