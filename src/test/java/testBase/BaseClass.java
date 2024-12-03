package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public Properties p;
	public static WebDriver driver;
	public Logger logger;
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup( String os,String br) throws IOException
	{
		
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
			 p=new Properties();
				p.load(file);//loading config.properties file

		logger=LogManager.getLogger(this.getClass());//log4j
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
				
			}
			else
			{
				System.out.println("No Matching os");
				return;
			}
			
			//browser
			
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox" : capabilities.setBrowserName("firefox");break;
			default : System.out.println("No matching browser");return;
			
			
			}
			
			
			driver=new RemoteWebDriver(new URL("http://192.168.1.17:4444/wd/hub"),capabilities);
			
			
			
		}
		
		
		
		
		//execute_env==local

		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
				case "chrome": driver=new ChromeDriver();break;
				case "edge":   driver=new EdgeDriver();break;
				case "firefox":  driver=new FirefoxDriver();break;
				default:System.out.println("Invalid Browser");return;
			}


		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url1")); // reading url from config file
		driver.manage().window().maximize();
		
		
	}
	
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.close();
	}
	public String randomString()
	{
	   String randomStr=RandomStringUtils.randomAlphabetic(5);
	   return randomStr;
	}
	
	public String randomNumber()
	{
		String randomnum=RandomStringUtils.randomNumeric(10);
		return randomnum;
	}
	
	public String randomAlphaNumueric()
	{
		String randomStr=RandomStringUtils.randomAlphabetic(5);
		String randomnum=RandomStringUtils.randomNumeric(10);
		 return (randomStr+"@"+randomnum);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
	
	
	
	
	
	

}
