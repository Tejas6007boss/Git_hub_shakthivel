package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_accountPage extends BasePage
{

	public My_accountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//h2[.='My Account']")
			WebElement msgheading;
	
	@FindBy(xpath="//a[.='Logout']")
	WebElement logout;
	public void logoutbtn()
	{
		logout.click();
	}
	
	public boolean ismyaccountdisplayed()
	{
		try {
			return(msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
			
		}
	}
	
	

}
