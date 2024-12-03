package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass{
	
	
    @Test(groups= {"regression","master"})
	public void verifyLoginTest() {
           
		
		try
		{
		logger.info("......Test Sarted Logintest....");
		HomePage hp=new HomePage(driver);
		hp.myAccounclickt();
		hp.loginclick();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		MyAccountPage mp=new MyAccountPage(driver);
		boolean bb=mp.verifyMyaccount();
		
		Assert.assertTrue(bb);
		}
		catch(Exception e)
		{
			Assert.fail();
		}



	}
	

}
