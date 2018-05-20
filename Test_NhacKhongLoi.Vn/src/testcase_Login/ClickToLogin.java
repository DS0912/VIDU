package testcase_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ClickToLogin {
	public static void main(String[] args) {
		try {
			//web driver's property
			System.setProperty("webdriver.gecko.driver","src/geckodriver.exe");

			//access http://nhackhongloi.vn
			WebDriver driver = new FirefoxDriver();
	        driver.get("http://nhackhongloi.vn/");
	        
	        //find Login button and click
	        By login = By.xpath("//*[@id=\"header-content\"]/div[2]/div/a");
	        WebElement Login = driver.findElement(login);
	        Login.click();
	        
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
