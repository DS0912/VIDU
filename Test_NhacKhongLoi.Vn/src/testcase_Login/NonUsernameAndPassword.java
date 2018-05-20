package testcase_Login;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NonUsernameAndPassword {
	public static void main(String[] args) {
		try {
			//web driver's property
			System.setProperty("webdriver.gecko.driver","src/geckodriver.exe");
		
			//access http://nhackhongloi.vn
			WebDriver driver = new FirefoxDriver();
	        driver.get("http://nhackhongloi.vn/default/login");
	        
	        //find Login button and click
	        By BtnLogin = By.xpath("//button[@type='submit']");
	        WebElement Login = driver.findElement(BtnLogin);
	        Login.click();
	        
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        By dialog = By.id("commonDialogContent");
	        WebElement Dialog = driver.findElement(dialog);
	        String Error = Dialog.getText();
	        
	        try {
		        //Compare text
	        	Assert.assertEquals(Error, "Not valid username or email!\n[-]");
	        
		        //close web browser
		        driver.close();
		        
		        System.out.println("Successfully !");
	        	}
	        	catch(AssertionError as) {
					System.out.println("Fail !");
					System.out.println(as.toString());
	        	}
			}
	        catch(Exception ex) {
				System.out.println("Fail !");
				System.out.println(ex.toString());	
	        }
	}
}
