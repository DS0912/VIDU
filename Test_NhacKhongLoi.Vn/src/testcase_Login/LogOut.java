package testcase_Login;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogOut {
	public static void main(String[] args) {
		try {
			//web driver's property
			System.setProperty("webdriver.gecko.driver","src/geckodriver.exe");
		
			//access http://nhackhongloi.vn
			WebDriver driver = new FirefoxDriver();
	        driver.get("http://nhackhongloi.vn/default/login");
	        
	        //Login
	        By username = By.id("username");
	        WebElement Username = driver.findElement(username);
	        Username.sendKeys("0912.ds3@gmail.com");
	        
	        By password = By.id("password");
	        WebElement Password = driver.findElement(password);
	        Password.sendKeys("@123456!");
	        
	        //find Login button and click
	        By BtnLogin = By.xpath("//button[@type='submit']");
	        WebElement Login = driver.findElement(BtnLogin);
	        Login.click();
	         
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        //find Logout button and click
	        By btnLogout = By.cssSelector("#header-content > div.wp-topmenu > div > a:nth-child(1) > svg");
	        WebElement BtnLogout = driver.findElement(btnLogout);
	        BtnLogout.click();
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
	        //close web browser
	        driver.close();
	        
	        System.out.println("Successfully !");
    		}
    		catch(Exception ex) {
				System.out.println("Fail !");
				System.out.println(ex.toString());	
    		}
	}
}
