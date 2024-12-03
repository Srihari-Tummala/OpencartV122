package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement but_login;
	
	public void myAccounclickt()
	{
		myaccount.click();
	}
	public void registerclick()
	{
		register.click();
	}
	
	public void loginclick()
	{
		but_login.click();
	}
	
	
	
	

}
