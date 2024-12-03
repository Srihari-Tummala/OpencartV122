package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage
{
	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_phone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_conpass;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement rad_button;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_box;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement but_cont;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement getMess;
	
	
	public void setFirstName(String firname)
	{
		txt_firstname.sendKeys(firname);
	}
	public void setLasttName(String lastname)
	{
		txt_lastname.sendKeys(lastname);
	}
	public void setEmail(String em)
	{
		txt_email.sendKeys(em);
	}
	public void setPhone(String ph)
	{
		txt_phone.sendKeys(ph);
	}
	public void setPass(String pass)
	{
		txt_password.sendKeys(pass);
	}
	public void setConpas(String cpas)
	{
		txt_conpass.sendKeys(cpas);
	}
	
	public void radioClick()
	{
		rad_button.click();
	}
	public void checkclick()
	{
		chk_box.click();
	}
	
	public void clickconti()
	{
		but_cont.click();
	}
	
	public String validateMess()
	{
		try
		{
			 return getMess.getText();
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
}
