package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import pages.BusPage;
import utils.Base;
import utils.Reporter;
import uistore.BusUI;
import utils.LoggerHandler;

public class Testcase2 extends Base {
	
    private final static Logger logger = Logger.getLogger(Testcase2.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private BusPage Bpage = new BusPage();
    
    
    
    @Test(priority = 2)
    public void clothpg() throws IOException, InvalidFormatException{
    	Bpage.Source();
    	Bpage.Destination();
    	Bpage.Datepicker();
    	Bpage.Search_btn();
   
        logger.info("Testcase2 passed Successfully"); 
    }

@BeforeMethod
public void beforeMethod() throws MalformedURLException {
    openBrowser();
    reporter = Reporter.generateExtentReport();
}

    @AfterMethod
    public void afterMethod() {
       driver.quit();
        reporter.flush();
      
    }
}

