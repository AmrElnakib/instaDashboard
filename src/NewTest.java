import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest 
{
	RemoteWebDriver driver= new ChromeDriver();
	
  @Test(priority = 1)
  public void Successfull_Login() 
 {
	  
	  		
	  		driver.get("https://dashboard.instabug.com/login");
	  		
	  		LoginPage.txtBox_Email(driver).sendKeys("ama");
	  		
	  		LoginPage.txtBox_Password(driver).sendKeys("123456");
	  		
	  		LoginPage.btn_Login(driver).submit();
	  		
	  		String url = driver.getCurrentUrl();
	  		
	  		Assert.assertEquals(url, "https://dashboard.instabug.com/home");
}

  @Test(priority = 1)
  public void Empty_Login() 
  
  {
	  
	  		
	  		driver.get("https://dashboard.instabug.com/login");
	  		
	  		LoginPage.txtBox_Email(driver).sendKeys("");
	  		
	  		LoginPage.txtBox_Password(driver).sendKeys("");
	  		
	  		LoginPage.btn_Login(driver).submit();
	  		
	  		if(LoginPage.btn_Login(driver).isEnabled())
	  		{
	  			Assert.fail();
	  		}

   }
  
  @Test(priority = 2)
  public void Failed_Incorrect_Login() 
  {
	  
	  		
	  		driver.get("https://dashboard.instabug.com/login");
	  		
	  		LoginPage.txtBox_Email(driver).sendKeys("abc");
	  		
	  		LoginPage.txtBox_Password(driver).sendKeys("123456");
	  		
	  		LoginPage.btn_Login(driver).submit();
	  		
	  		String messageExpected = "Your email and/or password are incorrect";
	  		String message = driver.findElementByClassName("body > div.u-display-block.u-full-height > ui-view > ng-include > main > div > div > div > div > div > div.u-bottom-margin--3x > form > div.callout.alert.small > p").getText();

	  		Assert.assertTrue(message.contains(messageExpected));
	  		
   }

  
  @BeforeMethod
  public void beforeMethod() 
  {
	  
		
		RemoteWebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() 
  
  {
	  
	  driver.close();
	  driver.quit();
  }

}
