
package pages;

import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import uistore.TrainsUI;
import utils.Base;
import utils.ExcelReader;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
import utils.LoggerHandler;
import utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TrainsPage extends Base {

    private Map<String, String> testData;
   private final static Logger logger = Logger.getLogger(TrainsPage.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private ExcelReader file = new ExcelReader();
    private ExtentTest test = reporter.createTest("Navigation To Trains", "Assert Login page");

    public void Train_check() {
        try {
            
        	 WebDriverHelper.ClickOnElement(TrainsUI.Train_nav);
             logger.info("Clicked Homepage/Trains");
             test.log(Status.PASS,"Clicked Trains");
             
             String title = driver.getCurrentUrl();
             String kword = "trains";
             assert title.contains(kword) : "The URL does not contain the keyword '" + kword + "'";
             logger.info("Assert Successfull");
             test.log(Status.PASS,"Trains Page Assert Successfull");

             WebDriverHelper.ClickOnElement(TrainsUI.Home_nav);
             logger.info("Navigated Back To Homepage");
             test.log(Status.PASS,"Navigated Successfull");
             
             WebDriverHelper.ClickOnElement(TrainsUI.Login_home);
             logger.info("Clicked Home/Login");
             test.log(Status.PASS,"Clicked Home/Login Button");
             
             String login_text = WebDriverHelper.getText(TrainsUI.Assert_login);
             String verify_text = "Login to AbhiBus";
             assert login_text.contains(verify_text):"The URL does not contain the keyword '" + verify_text + "'";
             logger.info("Asserted Login Popup");
             test.log(Status.PASS,"Login popup Verified");
            
             Screenshot.getScreenShot(driver, "Login_Popup");

            
        } catch (Exception e) {
            logger.error("Exception occurred while performing Trains search: " + e.getMessage(), e);
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Error While Accessing Trainspage ");
            test.fail("Failed to Trains search", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
    
 
    
    
    
}



