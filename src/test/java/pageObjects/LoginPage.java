package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_pass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement but_login;
	
	
	public void setEmail(String em)
	{
		txt_email.sendKeys(em);
	}
	public void setPassword(String pas)
	{
		txt_pass.sendKeys(pas);
		
	}
	public void clickLogin()
	{
		but_login.click();
	}
	
	
	
	
	
	
	
	

}
