package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003LoginDDT extends BaseClass{
	
	
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verifyDDTLoginTest(String email,String pass,String status)
	{
		logger.info("............DDT Login Test strated.............");
		
	try {	
		HomePage hp=new HomePage(driver);
		hp.myAccounclickt();
		hp.loginclick();
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		Thread.sleep(3000);
		lp.clickLogin();
		MyAccountPage mp=new MyAccountPage(driver);
		boolean bb=mp.verifyMyaccount();
		
		/*
		 data valid             login  -------passed---logout
		                        not login---  fail
		  data Invalid          login---      fail-- ---logout
		                        not login---  passed 
		                        
		                        	 */
		
		if(status.equalsIgnoreCase("Valid"))
		{
			if(bb==true)
			{
				Thread.sleep(3000);
				mp.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}

		if(status.equalsIgnoreCase("InValid"))
		{
			if(bb==true)
			{
				mp.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("****************TestFinished*********");
		
		
		
	}
	
	
	

}
