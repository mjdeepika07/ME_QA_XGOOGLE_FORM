/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        
        // This is to remove unnecessary warnings from your console
        System.setProperty("java.util.logging.config.file", "logging.properties");
        
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here

        tests.TC_01_navigateToGoogleFormUrl();
        tests.TC_02_enterName();
        tests.TC_03_whyAutomation();
        tests.TC_04_howMuchAutomationExp();
        tests.TC_05_skillsLearntAtCrio();
        tests.TC_06_titleToBeAddressed();
        tests.TC_07_dateSevenDaysAgo();
        tests.TC_08_currentTime24hrsFormat();
        tests.TC_09_getAmazonUrl();
        tests.TC_10_clickSubmit();
        tests.TC_11_printSuccessMessage();

        // END Tests


        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
