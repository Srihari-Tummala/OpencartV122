package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement imgmyacct;
	
	@FindBy(xpath="(//*[text()='Logout'])[2]")
	WebElement but_logout;
	
	public void clicklogout()
	{
		but_logout.click();
	}
	
	
	public boolean verifyMyaccount()
	{
		try 
		{
		boolean myac=imgmyacct.isEnabled();
		return myac;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	
	
	
	
}
