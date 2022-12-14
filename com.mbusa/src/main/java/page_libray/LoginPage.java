package page_libray;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailAddInputField;

    @FindBy(xpath = "//button[@id = 'continue' ]")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@id = 'password' ]")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@id = 'confirm' ]")
    public WebElement nextButton;

    @FindBy(xpath = "//button[@class = 'nav-profile__logout nav-profile__link ']")
    public WebElement logoutButton;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    private void sendKeysEmailAdd(String email) {
        sendKeysToElement(emailAddInputField, email);
    }

    private void clickContinueButton() {
        clickOnElement(continueButton);
    }

    private void sendKeysPassword(String password) {
        sendKeysToElement(passwordInputField, password);
    }

    private void clickNextButton() {
        clickOnElement(nextButton);
    }

    public void loginToAccount(String emailAdd, String password){
        sendKeysEmailAdd(emailAdd);
        clickContinueButton();
        sendKeysPassword(password);
        clickNextButton();
    }



    public void clickLogoutButton(){
        safeClickOnElement(logoutButton);
    }


}
