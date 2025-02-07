package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class Homecart extends BasePage
	{

		public  Homecart(WebDriver driver)
		{
			super(driver);
		}

		@FindBy(xpath="//a[.='Register']")
		WebElement myregistration;
		
		@FindBy(xpath="//span[.='My Account']")
		WebElement myaccount;
		
		@FindBy(xpath="//a[.='Login']")
		WebElement loginbtn;
		
		
		public void clickMyaccount()
		{
			myaccount.click();
		}
		public void clickregister()
		{
			 myregistration.click();
			
		}
		public void loginbtn()
		{
			loginbtn.click();
			
		}

}