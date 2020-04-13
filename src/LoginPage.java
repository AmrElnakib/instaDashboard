import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage {
	
	 public static WebElement element = null;
	 
	public static WebElement txtBox_Email (RemoteWebDriver driver)
	{
		
		element = driver.findElementById("developer_email");
		
		return element;
	}

	public static WebElement txtBox_Password (RemoteWebDriver driver)
	
	{
		element = driver.findElementById("password");
		
		return element;
		
	}
	
public static WebElement btn_Login (RemoteWebDriver driver)
	
	{
		element = driver.findElementByXPath("/html/body/div[2]/ui-view/ng-include/main/div/div/div/div/div/div[2]/form/button");
		
		return element;
		
	}

}
