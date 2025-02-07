package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage  extends BasePage
{

	public loginpage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	
	public void clickMyemaildid(String mail)
	{
		emailid.sendKeys(mail);
	}
	public void clickMypasword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickMyloginbtn()
	{
		loginbtn.click();
	}
	
}
