package runner;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import pages.BusPage2;
import utils.Base;
import utils.Reporter;
import pages.BusPage;
import org.apache.log4j.Logger;

public class Testcase3 extends Base {
	
    private final static Logger logger = Logger.getLogger(Testcase3.class);
    private ExtentReports reporter = Reporter.generateExtentReport();
    private BusPage2 Tpage = new BusPage2();

    
    
    @Test(priority = 3)
    public void Buspg2() throws IOException, InvalidFormatException{
    	Tpage.Source();
    	Tpage.Destination();
    	Tpage.Datepicker();
    	Tpage.Search_btn(); 		
    logger.info("Testcase3 passed Successfully");
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

