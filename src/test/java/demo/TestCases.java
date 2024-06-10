package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;


public class TestCases {
    ChromeDriver driver;
    

    Wrappers wrappers = new Wrappers();
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

    /*
     * Pseudo Code
     * Use wrapperMethod_getUrl() to fetch the desired url using driver.get(url) method
     */
    //TC_01_navigateToGoogleFormUrl
    @Test
    public void testCase01() throws InterruptedException{
        
        System.out.println("Start Test case: TC_01_navigateToGoogleFormUrl");
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform";
        
        wrappers.wrapperMethod_getUrl(driver, url);
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
    //TC_02_enterName
    @Test
    public void testCase02()throws InterruptedException{
        
        System.out.println("Start Test case: TC_02_enterName");
        WebElement weName = driver.findElement(By.xpath("//div//span[text()='Name']/ancestor::div[@class='geS5n']//input"));
        String userName = "Crio Learner";
        wrappers.wrapperMethod_SendKeys(driver, weName, userName);
        System.out.println("End Test case: TC_02_enterName");



    }

    /*
     * Pseudo code:
     * Get the epoch time
     * Concatenate the input string with the epoch time
     * Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
     * Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
     */
    //TC_03_whyAutomation
    @Test
    public void testCase03() throws InterruptedException{
        try{

        System.out.println("Start Test case: TC_03_whyAutomation");
        //Get the epoch time
        long epochTime = System.currentTimeMillis()/1000;
        //Concatenate the input string with the epoch time
        String whyAutomationAnswer = "I want to be the best QA Engineer! "+epochTime;
        //Locate the webelement using Locator xpath : //span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea
        WebElement weWhyAutomation = driver.findElement(By.xpath("//span[text()='Why are you practicing Automation?']/ancestor::div[@class='z12JJ']/following-sibling::div//textarea"));
        //Call the wrapperMethod_SendKeys() method by passing the driver, webelement and the input string
        wrappers.wrapperMethod_SendKeys(driver, weWhyAutomation, whyAutomationAnswer);
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
    //TC_04_howMuchAutomationExp
    @Test
    public void testCase04() throws InterruptedException{

        System.out.println("Start Test case: TC_04_howMuchAutomationExp");
        List<WebElement> weyearsOfAutomationExpOptions = driver.findElements(By.xpath("//div[@class='nWQGrd zwllIb']//span[@class='aDTYNe snByac OvPDhc OIC90c']"));
        String inputAutomationExp = "6 - 10";
        wrappers.wrapperMethod_ChooseAutomationExp(driver, weyearsOfAutomationExpOptions, inputAutomationExp);

        System.out.println("End Test case: TC_04_howMuchAutomationExp");

    }

    /*
     * Pseudo Code
     * Get all the available Skill options into a list of webelements 'weskillsLearntOptions' using the Locator xpath : //div[@class='eBFwI']
     * Store group of skills learnt in a string array 'inputSkillsLearntStrArray'
     * Call the wrapper method 'wrapperMethod_SelectSkillsLearnt' and pass 'weskillsLearntOptions' and 'inputSkillsLearntStrArray' along with driver object
     */
    //TC_05_skillsLearntAtCrio
    @Test
    public void testCase05() throws InterruptedException{

        System.out.println("Start Test case: TC_05_skillsLearntAtCrio");
        List<WebElement> weskillsLearntOptions = driver.findElements(By.xpath("//div[@class='eBFwI']"));
        String[] inputSkillsLearntStrArray = {"Java","Selenium","TestNG"};

        //JavascriptExecutor to scroll into the view of the desired webelement
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //scroll into the view to find the desired web element.
        js.executeScript("arguments[0].scrollIntoView(true);",weskillsLearntOptions.get(0));

        wrappers.wrapperMethod_SelectSkillsLearnt(driver, weskillsLearntOptions, inputSkillsLearntStrArray);

        System.out.println("End Test case: TC_05_skillsLearntAtCrio");

    }

    

    /*
     * Pseudo code
     * Get all the avaialble titles from the dropdown list and store them in List of webelements 'weTitlesToBeAddressed' using the locator xpath: //div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']
     * Store the desired title in 'desiredTitleStr'
     * Call the 'wrapperMethod_SelectDesiredTitle' method by passing the 'weTitlesToBeAddressed', 'desiredTitleStr' along with driver
     */
    //TC_06_titleToBeAddressed
    @Test
    public void testCase06() throws InterruptedException{

        System.out.println("Start Test case: TC_06_titleToBeAddressed");
        List<WebElement> weTitlesToBeAddressed = driver.findElements(By.xpath("//div[contains(@class,'MocG8c HZ3kWc mhLiyf OIC90c LMgvRb') and @role='option']"));
        String desiredTitleStr = "Mrs";
        wrappers.wrapperMethod_SelectDesiredTitle(driver, weTitlesToBeAddressed, desiredTitleStr);
        Thread.sleep(2000);
        System.out.println("End Test case: TC_06_titleToBeAddressed");

    }

    /*
     * Pseudo code
     * Call a wrapper method to send the seven days before current date in 'dd/MM/yyyy' format
     */
    //TC_07_dateSevenDaysAgo
    @Test
    public void testCase07() throws InterruptedException{

        System.out.println("Start Test case: TC_07_dateSevenDaysAgo");
        Thread.sleep(10000);
        wrappers.wrapperMethod_getCurrentDateMinusSeven(driver);
        Thread.sleep(5000);
        System.out.println("End Test case: TC_07_dateSevenDaysAgo");


    }

    //Call a Wrapper method wrapperMethod_sendCurrentTime24hrsFormat() to send the hours and minutes separately
    //TC_08_currentTime24hrsFormat
    @Test
    public void testCase08() throws InterruptedException{

        System.out.println("Start Test case: TC_08_currentTime24hrsFormat");

        wrappers.wrapperMethod_sendCurrentTime24hrsFormat(driver);

        System.out.println("End Test case: TC_08_currentTime24hrsFormat");

    }

    /*
     * Pseudo code
     * Declare a string variable 'url' and save "https://www.amazon.in/" url
     * Call wrapperMethod_getUrl() method by passing the driver instance and the amazon url to got to amazon homepage
     * Call wrapperMethod_clickCancel() method by passing the driver object to dismiss the alert  
     */
    //TC_09_getAmazonUrl
    @Test
    public void testCase09() throws InterruptedException{

        System.out.println("Start Test case: TC_09_getAmazonUrl");

        String url = "https://www.amazon.in/";
        wrappers.wrapperMethod_getUrl(driver, url);
        Thread.sleep(2000);
        wrappers.wrapperMethod_clickCancel(driver);
        System.out.println("End Test case: TC_09_getAmazonUrl");
    

    }

    /*
     * Pseudo code
     * Locate a WebElement 'weSubmitButton' using the Locator xpath : //span[text()='Submit']
     * Call the wrapper method wrapperMethod_clickSubmit() by passing the driver object 
     * and the 'weSubmitButton' WebElement to click the submit button
     */
    //TC_10_clickSubmit
    @Test
    public void testCase10() throws InterruptedException{

        System.out.println("Start Test case: TC_10_clickSubmit");

        WebElement weSubmitButton = driver.findElement(By.xpath("//span[text()='Submit']"));
        wrappers.wrapperMethod_clickSubmit(driver, weSubmitButton);

        System.out.println("End Test case: TC_10_clickSubmit");
        Thread.sleep(2000);
        
        
    }


    //Wrapper method to check if the success message is displayed on the screen and then print it on the console
    //TC_11_printSuccessMessage
    @Test
    public void testCase11(){

        System.out.println("Start Test case: TC_11_printSuccessMessage");

        //Locate a WebElement 'weSuccessMessage' using the locator xpath : //div[@class='vHW8K']
        WebElement weSuccessMessage = driver.findElement(By.xpath("//div[@class='vHW8K']"));
    
        String expectedSuccessMessage = "Thanks for your response, Automation Wizard!";

        //Wrapper method to compare the actual and expected success messages
        wrappers.wrapperMethod_compareText(driver, weSuccessMessage, expectedSuccessMessage);  
    
        System.out.println("End Test case: TC_11_printSuccessMessage");

    }

 




     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        //For each webElement search, wait implicitly for 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        

    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}