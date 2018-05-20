package testcase_AccountInformation;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class NewPasswordNotMatch {
	public static void main(String[] args) {
		try {
			//web driver's property
			System.setProperty("webdriver.gecko.driver","src/geckodriver.exe");
			
			//access http://nhackhongloi.vn
			WebDriver driver = new FirefoxDriver();
	        driver.get("http://nhackhongloi.vn/default/login");
	        
	        //User's Information
	        By username = By.id("username");
	        WebElement Username = driver.findElement(username);
	        Username.sendKeys("1810.ds1@gmail.com");
	        
	        By password = By.id("password");
	        WebElement Password = driver.findElement(password);
	        Password.sendKeys("@!123456");
	        
	        //find Login button and click
	        By BtnLogin = By.xpath("//button[@type='submit']");
	        WebElement Login = driver.findElement(BtnLogin);
	        Login.click();
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        //find Username/email and click
	        By mail = By.xpath("//*[@id=\"header-content\"]/div[2]/div/a[2]");
	        WebElement Mail = driver.findElement(mail);
	        Mail.click();
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        //find Change Password and click
	        By changepw = By.xpath("//*[@id=\"div-content-wrapper\"]/section/div/div[2]/div/div/table/tbody/tr[5]/td[2]/a");
	        WebElement Changepw = driver.findElement(changepw);
	        Changepw.click();     
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	        
	        //old password
	        By oldpassword = By.id("oldPassword");
	        WebElement Oldpassword = driver.findElement(oldpassword);
	        Oldpassword.sendKeys("@!123456");
	        
	        //new password 1
	        By newPassword1 = By.id("newPassword1");
	        WebElement NewPassword1 = driver.findElement(newPassword1);
	        NewPassword1.sendKeys("12341234");
	        
	        //new password 2
	        By newPassword2 = By.id("newPassword2");
	        WebElement NewPassword2 = driver.findElement(newPassword2);
	        NewPassword2.sendKeys("12345678");
	        
	        //find Change Password Button and click
	        By changepassbtn = By.id("clickChangePw");
	        WebElement Changepassbtn = driver.findElement(changepassbtn);
	        Changepassbtn.click();
	        
	        //get alert
	        Alert alert = driver.switchTo().alert();
	        String al = alert.getText();
	        alert.accept();
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		    try {
	        	//compare alert
		        Assert.assertEquals(al, "Mậu khẩu mới phải trùng nhau!");   
		        
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
