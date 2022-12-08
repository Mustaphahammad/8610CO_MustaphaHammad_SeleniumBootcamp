package page_library;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;

public class CheckoutPage extends BasePage {


    @FindBy(css = "#first-name")
    public WebElement firstNameInputText;

    @FindBy(css = "#last-name")
    public WebElement lastNameInputText;

    @FindBy(css = "#postal-code")
    public WebElement zipCodeInputText;

    @FindBy(css = "#continue")
    public WebElement continueButton;

    @FindBy(css = "#finish")
    public WebElement finishButton;

    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    public static WebElement thankYouMessage;



    public CheckoutPage(){
        PageFactory.initElements(driver,this);
    }

    public void sendKeysFirstName(WebElement element, String firstName){

        sendKeysToElement(element,firstName);
    }

    public void sendKeysLastName(WebElement element, String lastName){
        sendKeysToElement(element,lastName);
    }

    public void sendKeysZipCode(WebElement element, String zipCode){
        sendKeysToElement(element,zipCode);
    }

    public void checkoutFillingForm(){
         String fName = GenerateData.firstName();
         String lName = GenerateData.lastName();
         String zCode = GenerateData.zipCode();
        sendKeysFirstName(firstNameInputText,fName);
        sendKeysLastName(lastNameInputText,lName);
        sendKeysZipCode(zipCodeInputText,zCode);
        clickOnElement(continueButton);
        clickOnElement(finishButton);
    }






}
