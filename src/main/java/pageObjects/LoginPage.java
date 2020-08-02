package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	private By email=By.cssSelector("#user_email");
	private By password=By.cssSelector("#user_password");
	private By submit=By.cssSelector("[value='Log In']");
	private By forgotpassword=By.cssSelector("a[href*='password']");	
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement submit()
	{
		return driver.findElement(submit);
	}
	
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotpassword).click();
		return new ForgotPassword(driver);
		
	}
}
