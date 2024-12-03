package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass
{
	
	@Test(groups={"sanity","master"})
	void verifyAccoutRegistration() throws InterruptedException
	{ 
		logger.info("*******************Testing Started*******************");
		logger.debug("THIS IS A DEBUG LOG MESSAGE");
		try {
		HomePage hp=new HomePage(driver);
		
		logger.info("click my account");
		hp.myAccounclickt();
		logger.info("click register");
		hp.registerclick();
		Thread.sleep(5000);
		
		logger.info("Providing customer details....");
		AccountRegisterPage ar=new AccountRegisterPage(driver);
		ar.setFirstName(randomString().toUpperCase());
		ar.setLasttName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");
		ar.setPhone(randomNumber());
		
		String password=randomAlphaNumueric();
		ar.setPass(password);
		ar.setConpas(password);
		ar.radioClick();
		ar.checkclick();
		ar.clickconti();
		String validatemess=ar.validateMess();
		  
		if(validatemess.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			
			
		}
		else
		{
			logger.error("...Test failedmessage....");
			logger.debug("...debug logs..............");
			Assert.assertTrue(false);
			
		}
		//Assert.assertEquals(validatemess,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
			
		}
		
		logger.info(".....TestFinished.............");
		
		
	}
	
	
	
}
