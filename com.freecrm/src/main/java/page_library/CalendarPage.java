package page_library;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class CalendarPage extends BasePage {

    @FindBy(xpath = "//a[@href='/calendar/new']")
    public WebElement createButton;

    @FindBy(xpath = "//span[@class = 'rbc-toolbar-label']")
    public WebElement calendarToolBarLabel;

    @FindBy(xpath = "//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[1]/button[2]")
    public WebElement calendarLeftButton;

    @FindBy(xpath = "//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[1]/button[3]")
    public WebElement calendarRightButton;

    @FindBy(xpath = "//i[@class ='calendar icon']")
    public WebElement calendarIcon;

    //*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[10]/div[2]
    //*[@id="main-content"]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[1]






    public CalendarPage(){
        PageFactory.initElements(driver,this);
    }
    /* Enter number:
     1 for month
     2 for week
     3 for day
     4 for agenda*/
    private void clickCalendarMonthWeekdayButton (int number){
        WebElement element = driver.findElement(By.xpath("//*[@id='main-content']/div/div[2]/div/div[2]/div/div[1]/span[3]/button["+number+"]"));
        clickOnElement(element);
    }
    public void selectDateFromMonthCalendar(String year, String month,String day){
        String desiredMonth= month +" "+ year;
        while(true){
           String actText = calendarToolBarLabel.getText();
           if(desiredMonth.equals(actText)){
               break;
           }else{
               LocalDate date = LocalDate.of(Integer.parseInt(year),Month.valueOf(month.toUpperCase()),Integer.parseInt(day));
               LocalDate todayDate = LocalDate.now();
               if(date.isBefore(todayDate)){
                   clickOnElement(calendarLeftButton);
               }else{
                   clickOnElement(calendarRightButton);
               }
               chooseDateFromMonthCalendar(Integer.parseInt(day));
           }
        }
    }
    private void chooseDateFromMonthCalendar(int date){
        WebElement chosenDay = driver.findElement
                (By.xpath("//*[@class = 'rbc-row-content']//div[@class = 'rbc-date-cell' " +
                                       "or @class = 'rbc-date-cell rbc-current']//a[text() = '"+date+"']"));
        clickOnElement(chosenDay);
    }

    //public chooseWeekDay()


}
