package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    
    //ChromeDriver driver;

    //Create a WebDriverWait object with a timeout of 10 seconds, this object 
    //can be used to perform explicit waits for desired expected conditions          
    WebDriverWait wait;
    /*
     * Write your selenium wrappers here
     */

     //Wrapper Method to go to the desired url
    public void wrapperMethod_getUrl(ChromeDriver driver, String url){
        //If the current URL is not same as the desired url, fetch the desired url
        if(!driver.getCurrentUrl().equals(url))
            driver.get(url);
    }


    //Wrapper method to send keys to the input field
    public void wrapperMethod_SendKeys(ChromeDriver driver, WebElement webelement, String inputString) throws InterruptedException{
        //Pass the string variable inputString using webelement.sendKeys() method 
        webelement.sendKeys(inputString);
            Thread.sleep(5000);

    }

    //Wrapper method to choose the number of years of automation experience
    public void wrapperMethod_ChooseAutomationExp(ChromeDriver driver, List<WebElement> weyearsOfAutomationExpOptions, String inputAutomationExp) throws InterruptedException{
        
        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //For each option 
        for(WebElement eachYearOfAutomationExp : weyearsOfAutomationExpOptions){
            //If the experience is same as that of the input experience
            if(eachYearOfAutomationExp.getText().equals(inputAutomationExp)){
                //System.out.println("The exp selected is : "+eachYearOfAutomationExp.getText());
                //Get the associated radio button of the desired exp option
                WebElement weSelectYearsOfExpOption = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb']//div[@class='Od2TWd hYsg7c' and @data-value='"+inputAutomationExp+"']"));
                js.executeScript("arguments[0].scrollIntoView(true);",weSelectYearsOfExpOption);
                //Click the radio button
                weSelectYearsOfExpOption.click();
                //Wait till the selection is completed
                Thread.sleep(2000);
                

            }

        }

    }

    //Wrapper method to select the various skills learnt at crio
    public void wrapperMethod_SelectSkillsLearnt(ChromeDriver driver, List<WebElement> weskillsLearntOptions, String[] inputSkillsLearntStrArray) throws InterruptedException{
    
        //For each skill available(outer for each loop), iterate all the learnt skills passed as input(inner for each loop)
        for(WebElement weEachSkillLearnt : weskillsLearntOptions){
            for(String eachInputSkillLearnt : inputSkillsLearntStrArray){
            //If the available skill is same as that of the input skill learnt
                if(weEachSkillLearnt.getText().equals(eachInputSkillLearnt)){
                    //System.out.println("The skill learnt is : "+weEachSkillLearnt.getText());
                    //Get the associated checkbox of the input skill learnt
                    WebElement weSelectSkillLearnt = driver.findElement(By.xpath("//div[@class='uVccjd aiSeRd FXLARc wGQFbe BJHAP oLlshd' and @aria-label='"+eachInputSkillLearnt+"']"));
                    //Select the select box
                    weSelectSkillLearnt.click();
                    //Wait till the selection is completed
                    Thread.sleep(2000);
                    
                }
            }

        }

    }

    
    //Wrapper method to select the desired input title
    public void wrapperMethod_SelectDesiredTitle(ChromeDriver driver, List<WebElement> weTitlesToBeAddressed, String desiredTitleStr) throws InterruptedException{
        //Search and Click on the Titles drop down
        WebElement weClickChoose = driver.findElement(By.xpath("(//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R'])[1]"));
        weClickChoose.click();
        
        //For each listed title
        for(WebElement weEachTitle : weTitlesToBeAddressed){
            
            //If the available title is same as that of the desired input title
            if(weEachTitle.getAttribute("data-value").equals(desiredTitleStr)){
                //wait for the element to be clickable . without wait got exception: Element not interactable
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement weTitleToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option' and @data-value='"+desiredTitleStr+"']")));
                //Select the select box
                weTitleToClick.click();
                break;
                
            }
            

        }

    }

    //Wrapper method to send the seven days before current date as input in 'dd/MM/yyyy' format
    public void wrapperMethod_getCurrentDateMinusSeven(ChromeDriver driver){

        //Get the local date using LocalDate.now() method and store it in a LocalDate variable
        LocalDate date = LocalDate.now();

        //Use the DateTimeFormatter.ofPattern("dd/MM/yyyy") method to the desired date format and store it in DateTimeFormatter variable
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Use LocalDate.minusDays() method to subtract the desired days from the current date to get the new date
        LocalDate newdate = date.minusDays(7);

        //Locate the webElement using Locator xpath : (//input[@class='whsOnd zHQkBf'])[2]
        WebElement weCalendar = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));

        // //Scroll down to find the desired element using JavascriptExecutor
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", weCalendar);
        
        //Convert the new date into desired date format using newdate.format(dateFormatter) 
        //and again convert to String using toString() method
        weCalendar.sendKeys(newdate.format(dateFormatter).toString());

    }


    /*
     * Pseudo code
     * Get the current time using LocalTime class and LocalTime.now() method
     * Get the desired time pattern(HH:mm) in 24hrs format using DateTimeFormatter class and DateTimeFormatter.ofPattern() method
     * Use the split() method and pass the delimiter ':' to get the hrs and mins values separately and store them in an array hrsMinsStr[]
     * Locate the WebElement weHoursIn24hrFormat using Locator xpath : (//input[@class='whsOnd zHQkBf'])[3] to pass the hrs(HH) value
     * Send the hrsMinsStr[0](HH value) using the weHoursIn24hrFormat.sendKeys() method
     * Locate the WebElement weMinsIn24hrFormat using Locator xpath : (//input[@class='whsOnd zHQkBf'])[4] to pass the Mins(mm) value
     * Send the hrsMinsStr[1](mm value) using the weMinsIn24hrFormat.sendKeys() method 
     */
    public void wrapperMethod_sendCurrentTime24hrsFormat(ChromeDriver driver) throws InterruptedException{

        //Get the current time using LocalTime class and LocalTime.now() method
        LocalTime currentTime = LocalTime.now();

        //Get the desired time pattern(HH:mm) in 24hrs format using DateTimeFormatter class and DateTimeFormatter.ofPattern() method
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        // System.out.println("currentTime.format(timeFormatter) : "+ currentTime.format(timeFormatter));

        //Use the split() method and pass the delimiter ':' to get the hrs and mins values separately and store them in an array hrsMinsStr[]
        String[] hrsMinsStr = currentTime.format(timeFormatter).split(":");
        // System.out.println("Hours : " + hrsMinsStr[0]);
        // System.out.println("Minutes : " + hrsMinsStr[1]);

        //Locate the WebElement weHoursIn24hrFormat using Locator xpath : (//input[@class='whsOnd zHQkBf'])[3] to pass the hrs(HH) value
        WebElement weHoursIn24hrFormat = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[3]"));
        
        // //Scroll down to find the desired element using JavascriptExecutor
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].scrollIntoView(true);", weHoursIn24hrFormat);
        
        //Send the hrsMinsStr[0](HH value) using the weHoursIn24hrFormat.sendKeys() method
        weHoursIn24hrFormat.sendKeys(hrsMinsStr[0]);

        //Locate the WebElement weMinsIn24hrFormat using Locator xpath : (//input[@class='whsOnd zHQkBf'])[4] to pass the Mins(mm) value
        WebElement weMinutesIn24hrFormat = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[4]"));
        
        //Send the hrsMinsStr[1](mm value) using the weMinsIn24hrFormat.sendKeys() method 
        weMinutesIn24hrFormat.sendKeys(hrsMinsStr[1]);

        Thread.sleep(3000);

    }

    //Wrapper method to dismiss the alert
    public void wrapperMethod_clickCancel(ChromeDriver driver){

        //Wait till the alert window is displayed
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        //Create an alert variable and switch the context to the alert
        Alert alert = driver.switchTo().alert();
        
        //Click on the cancel button by using alert.dismiss() method
        alert.dismiss();


    }

    //Wrapper method to click on the button
    public void wrapperMethod_clickSubmit(ChromeDriver driver, WebElement weSubmitButton){

        weSubmitButton.click();

    }

    //Wrapper method to compare the success message
    public void wrapperMethod_compareText(ChromeDriver driver, WebElement weSuccessMessage, String expectedSuccessMessage){

         //Get the text from the WebElement using the getText() method and then compare it with the expected text
         if(weSuccessMessage.getText().equals("Thanks for your response, Automation Wizard!")){
            //Print the success message on the console
            System.out.println(weSuccessMessage.getText());
        }  


    }




}
