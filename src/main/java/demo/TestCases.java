package demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;

//import io.github.bonigarcia.wdm.WebDriverManager;

// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.Test;
// import org.testng.Assert;


public class TestCases {
    //Initialize a ChromeDriver variable 
    ChromeDriver driver;
    
    //Initialize a WebDriverWait variable 
    WebDriverWait wait;

    //TestCases Constructor
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        //Create a chrome driver objectr
        driver = new ChromeDriver();
        //Maximize the browser window
        driver.manage().window().maximize();
        //For each webElement search, wait implicitly for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Create a WebDriverWait object with a timeout of 10 seconds, this object 
        //can be used to perform explicit waits for desired expected conditions       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    
    //Tear Down method
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        //Close the current chrome browser
        driver.close();
        //Close all opened chrome browsers
        driver.quit();

    }

    /*
     * Pseudo Code
     * Use wrapperMethod_getUrl() to fetch the desired url using driver.get(url) method
     */
    public void TC_01_navigateToGoogleFormUrl() throws InterruptedException{

        System.out.println("Start Test case: TC_01_navigateToGoogleFormUrl");
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
        wrapperMethod_getUrl(driver, url);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_01_navigateToGoogleFormUrl");
    }

    
    /*
     * Pseudo Code
     * This Test case is used to enter name
     * Locate the WebElement weName using the locator xpath : //div//span[text()='Name']/ancestor::div[@class='geS5n']//input
     * Initialize the String variable weName to "Crio Learner"
     * Call the wrapperMethod_SendKeys() by passing the driver, weName and input userName
     * 
     */
    public void TC_02_enterName()throws InterruptedException{
        
        System.out.println("Start Test case: TC_02_enterName");
        WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
        String userName = "Crio Learner";
        wrapperMethod_SendKeys(driver, weName, userName);
        System.out.println("End Test case: TC_02_enterName");



    }

    /*
     * Pseudo code:
     * Get the epoch time
     * Concatenate the input string with the epoch time
     * Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
     * Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
     */
    //@Test
    public void TC_03_whyAutomation() throws InterruptedException{
        try{

        System.out.println("Start Test case: TC_03_whyAutomation");
        //Get the epoch time
        long epochTime = System.currentTimeMillis()/1000;
        //Concatenate the input string with the epoch time
        String whyAutomationAnswer = "I want to be the best QA Engineer! "+epochTime;
        //Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
        WebElement weWhyAutomation = driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
        //Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
        wrapperMethod_SendKeys(driver, weWhyAutomation, whyAutomationAnswer);
        System.out.println("End Test case: TC_03_whyAutomation");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /*
     * Pseudo code
     * Get all the available experience options into a list of webelements 'weyearsOfAutomationExpOptions' using the Locator xpath : //div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']
     * Store one experience value to a string 'inputAutomationExp' 
     * Call the wrapper method 'wrapperMethod_ChooseAutomationExp' and pass 'weyearsOfAutomationExpOptions' and 'inputAutomationExp' along with driver object
     * 
     */
    public void TC_04_howMuchAutomationExp() throws InterruptedException{

        System.out.println("Start Test case: TC_04_howMuchAutomationExp");
        List<WebElement> weyearsOfAutomationExpOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String inputAutomationExp = "6 - 10";
        wrapperMethod_ChooseAutomationExp(driver, weyearsOfAutomationExpOptions, inputAutomationExp);

        System.out.println("End Test case: TC_04_howMuchAutomationExp");

    }

    /*
     * Pseudo Code
     * Get all the available Skill options into a list of webelements 'weskillsLearntOptions' using the Locator xpath : //div[@class='eBFwI']
     * Store group of skills learnt in a string array 'inputSkillsLearntStrArray'
     * Call the wrapper method 'wrapperMethod_SelectSkillsLearnt' and pass 'weskillsLearntOptions' and 'inputSkillsLearntStrArray' along with driver object
     */

    public void TC_05_skillsLearntAtCrio() throws InterruptedException{

        System.out.println("Start Test case: TC_05_skillsLearntAtCrio");
        List<WebElement> weskillsLearntOptions = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        String[] inputSkillsLearntStrArray = {"Java","Selenium","TestNG"};

        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //scroll into the view to find the desired web element.
        js.executeScript("arguments[0].scrollIntoView(true);",weskillsLearntOptions.get(0));

        wrapperMethod_SelectSkillsLearnt(driver, weskillsLearntOptions, inputSkillsLearntStrArray);

        System.out.println("End Test case: TC_05_skillsLearntAtCrio");

    }

    

    /*
     * Pseudo code
     * Get all the avaialble titles from the dropdown list and store them in List of webelements 'weTitlesToBeAddressed' using the locator xpath: //div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']
     * Store the desired title in 'desiredTitleStr'
     * Call the 'wrapperMethod_SelectDesiredTitle' method by passing the 'weTitlesToBeAddressed', 'desiredTitleStr' along with driver
     */
    public void TC_06_titleToBeAddressed() throws InterruptedException{

        System.out.println("Start Test case: TC_06_titleToBeAddressed");
        List<WebElement> weTitlesToBeAddressed = driver.findElements(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']"));
        String desiredTitleStr = "Mrs";
        wrapperMethod_SelectDesiredTitle(driver, weTitlesToBeAddressed, desiredTitleStr);
        Thread.sleep(2000);
        System.out.println("End Test case: TC_06_titleToBeAddressed");

    }

    /*
     * Pseudo code
     * Call a wrapper method to send the seven days before current date in 'dd/MM/yyyy' format
     */
    public void TC_07_dateSevenDaysAgo() throws InterruptedException{

        System.out.println("Start Test case: TC_07_dateSevenDaysAgo");
        Thread.sleep(10000);
        wrapperMethod_getCurrentDateMinusSeven(driver);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_07_dateSevenDaysAgo");


    }

    //Call a Wrapper method wrapperMethod_sendCurrentTime24hrsFormat() to send the hours and minutes separately
    public void TC_08_currentTime24hrsFormat() throws InterruptedException{

        System.out.println("Start Test case: TC_08_currentTime24hrsFormat");

        wrapperMethod_sendCurrentTime24hrsFormat(driver);

        System.out.println("End Test case: TC_08_currentTime24hrsFormat");

    }

    /*
     * Pseudo code
     * Declare a string variable 'url' and save "https://www.amazon.in/" url
     * Call wrapperMethod_getUrl() method by passing the driver instance and the amazon url to got to amazon homepage
     * Call wrapperMethod_clickCancel() method by passing the driver object to dismiss the alert  
     */
    public void TC_09_getAmazonUrl() throws InterruptedException{

        System.out.println("Start Test case: TC_09_getAmazonUrl");

        String url = "https://www.amazon.in/";
        wrapperMethod_getUrl(driver, url);
        Thread.sleep(2000);
        wrapperMethod_clickCancel(driver);
        System.out.println("End Test case: TC_09_getAmazonUrl");
    

    }

    /*
     * Pseudo code
     * Locate a WebElement 'weSubmitButton' using the Locator xpath : //span[text()='Submit']
     * Call the wrapper method wrapperMethod_clickSubmit() by passing the driver object 
     * and the 'weSubmitButton' WebElement to click the submit button
     */
    public void TC_10_clickSubmit() throws InterruptedException{

        System.out.println("Start Test case: TC_10_clickSubmit");

        WebElement weSubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        wrapperMethod_clickSubmit(driver, weSubmitButton);

        System.out.println("End Test case: TC_10_clickSubmit");
        Thread.sleep(2000);
        
        
    }


    //Wrapper method to check if the success message is displayed on the screen and then print it on the console
    public void TC_11_printSuccessMessage(){

        System.out.println("Start Test case: TC_11_printSuccessMessage");

        //Locate a WebElement 'weSuccessMessage' using the locator xpath : //div[@class='vHW8K']
        WebElement weSuccessMessage = driver.findElement(By.xpath("//div[@class='vHW8K']"));
    
        String expectedSuccessMessage = "Thanks for your response, Automation Wizard!";

        //Wrapper method to compare the actual and expected success messages
        wrapperMethod_compareText(driver, weSuccessMessage, expectedSuccessMessage);  
    
        System.out.println("End Test case: TC_11_printSuccessMessage");

    }





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











