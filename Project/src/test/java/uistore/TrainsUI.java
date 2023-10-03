package uistore;

import org.openqa.selenium.By;

public class TrainsUI {

        public static By Train_nav = By.xpath("//a/span[contains(text(),'Trains')]");
        public static By Home_nav = By.xpath("//div/a/img[@alt='Abhibus']");
        public static By Login_home = By.xpath("//a/span[contains(text(),'Login/SignUp')]");
        public static By Assert_login = By.xpath("//*[@id='login-heading']/div[1]/h4");
}   
