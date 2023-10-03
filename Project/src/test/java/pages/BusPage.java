package pages;

import static org.testng.Assert.assertListContains;
import static org.testng.Assert.assertTrue;

import java.util.Map;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import uistore.BusUI;
import uistore.TrainsUI;
import utils.Base;
import utils.ExcelReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import utils.LoggerHandler;
import utils.ReadPropertyFile;
import com.aventstack.extentreports.Status;
import java.util.concurrent.TimeUnit;

public class BusPage extends Base {

    private Map<String, String> testData;
    private final static Logger logger = Logger.getLogger(BusPage.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExcelReader file = new ExcelReader();
    private ExtentTest test = reporter.createTest("Bus Page Check", "Assert Source & Destination Keyword");
    int numberOfArrowDownPresses = 1;

    public void Source() {
        try {
            String source1 = file.ReadData("./testdata/Testdata.xlsx", "Abhibus", 2, "Source");
           

            WebDriverHelper.ClickOnElement(BusUI.from_Station);
            logger.info("Clicked Source Inputbox");
            test.log(Status.PASS,"Clicked Source");
                        
            WebElement inputBox = driver.findElement(BusUI.from_Station);
            inputBox.sendKeys(source1);
            logger.info("Value passed: " + source1);
            test.log(Status.PASS, "Source Value passed");
            
            
//            WebDriverHelper.sendKeys(BusUI.from_Station, source1);
//            logger.info("Value passed: " + source1);
//            test.log(Status.PASS,"Source Value passed");
            
            
            // Wait for a brief moment to allow the suggestion list to appear
            Thread.sleep(1000); // Adjust the sleep duration as needed

            for (int i = 0; i < numberOfArrowDownPresses; i++) {
                inputBox.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(100); // Add a small delay to ensure the list is updated
            }
            
         // Send Enter key to select the highlighted item
            inputBox.sendKeys(Keys.ENTER);
            logger.info("Selected the desired suggestion: " + source1);
            test.log(Status.PASS, "Selected the desired suggestion: " + source1);
                          
            
        } catch (Exception e) {
        	logger.error("Exception occurred while performing clothes search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Clothes Search Error");
            test.fail("Failed to perform Clothes search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
    
    public void Destination()
    
    {
    try {
    	 String source2 = file.ReadData("./testdata/Testdata.xlsx", "Abhibus", 2, "Destination");
    	
    	WebDriverHelper.ClickOnElement(BusUI.to_Station);
         logger.info("Clicked To Inputbox");
         test.log(Status.PASS,"Clicked Destination");
                     
//         WebDriverHelper.sendKeys(BusUI.to_Station, source2);
//         logger.info("Value passed: " + source2);
//         test.log(Status.PASS,"Source Value passed");
         
         WebElement inputBox = driver.findElement(BusUI.to_Station);
         inputBox.sendKeys(source2);
         logger.info("Value passed: " + source2);
         test.log(Status.PASS, "Destination Value passed");
         
         Thread.sleep(1000);
         for (int i = 0; i < numberOfArrowDownPresses; i++) {
             inputBox.sendKeys(Keys.ARROW_DOWN);
             Thread.sleep(100); }
         
         inputBox.sendKeys(Keys.ENTER);
         logger.info("Selected the desired suggestion: " + source2);
         test.log(Status.PASS, "Selected the desired suggestion: " + source2);
    	
    }
    	catch(Exception e) {
    		logger.error("Exception occurred while performing clothes search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Clothes Search Error");
            test.fail("Failed to perform Clothes search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	}
    	
    }
   
    
public void Datepicker()
    
    {
    try {
    	 
    	
    	WebDriverHelper.ClickOnElement(BusUI.datepick);
         logger.info("Clicked Datepicker");
         test.log(Status.PASS,"Clicked Date");
         
         Thread.sleep(1000);
                  
         WebDriverHelper.ClickOnElement(BusUI.click_date);
         logger.info("Clicked Current Date");
         test.log(Status.PASS,"Clicked Date");
         
    }
    	catch(Exception e) {
    		logger.error("Exception occurred while performing clothes search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Clothes Search Error");
            test.fail("Failed to perform Clothes search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    	}
    	
    }

public void Search_btn()

{
try {
	 
	
	WebDriverHelper.ClickOnElement(BusUI.click_search);
     logger.info("Clicked Search Button");
     test.log(Status.PASS,"Clicked Search");
     Thread.sleep(1000);
     String ast = driver.getCurrentUrl();
     String Kyword1 = "Mumbai";
     String Kyword2 = "Pune";
     
     if(ast.contains(Kyword1)&& ast.contains(Kyword2) )
     {
    	 System.out.println("URL contains both " + Kyword1 + " and " + Kyword2);
}
     
     else {
    	    // At least one of the keywords is missing in the URL
    	    System.out.println("URL does not contain both " + Kyword1 + " and " + Kyword2);
    	}
     
}
         
	catch(Exception e) {
		logger.error("Exception occurred while performing clothes search: " + e.getMessage(), e);
        String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Clothes Search Error");
        test.fail("Failed to perform Clothes search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
	}
	
}

}

