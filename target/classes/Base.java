package resources;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
		prop.load(fis);
		//mvn test -Dbrowser=chrome
		String browsername=System.getProperty("browser");
		//String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.contains("chrome"))
		{
			//execute chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options =new ChromeOptions();
			if(browsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			
							
		}
		
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			//execute firefox broser
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("ie"))
		{
			//execute IE browser
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
		public String getScreenshotPath(String testcasename, WebDriver driver) throws IOException
		{
			TakesScreenshot ts=	(TakesScreenshot) driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
			FileUtils.copyFile(source,new File(destinationFile));
			return destinationFile;
		}
	
	
	
}
