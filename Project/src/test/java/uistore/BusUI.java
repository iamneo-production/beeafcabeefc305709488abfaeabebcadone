
package uistore;

import org.openqa.selenium.By;
import utils.ExcelReader;

public class BusUI {
    public static By from_Station = By.xpath("//div/input[@placeholder='From Station']");
    public static By to_Station = By.xpath("//div/input[@placeholder='To Station']");
    public static By datepick = By.xpath("//div/input[@placeholder='Onward Journey Date']");
    public static By click_date = By.xpath("//*[@id=\"jaurney-date\"]/div/div/div/div[2]/input");
    public static By click_search = By.xpath(" //div[@id='search-button']");
    
}
