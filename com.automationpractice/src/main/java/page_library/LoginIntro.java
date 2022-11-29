package page_library;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIntro extends BasePage {

    @FindBy(css = "#user-name")
    public WebElement usernameInputText;


    @FindBy(css = "#password")
    public WebElement pswInputText;

    @FindBy(css = "#login-button")
    public WebElement loginButton;




    public LoginIntro() {
        PageFactory.initElements(driver, this);
    }

    public void sendKeysUserName(WebElement element,String username){
        sendKeysToElement(element,username);
    }

    public void sendKeysPsw (WebElement element,String psw){
        sendKeysToElement(element,psw);
    }

    public void clickLoginButton(WebElement element){
        clickOnElement(element);
    }


    public HomePage loginToMyAccount( String username, String password){
       sendKeysUserName(usernameInputText,username);
       sendKeysPsw(pswInputText,password);
       clickLoginButton(loginButton);
       return new HomePage();
    }

}
