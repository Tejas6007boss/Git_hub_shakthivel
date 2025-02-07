package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Account_Registration_page extends BasePage

{
	public Account_Registration_page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input [@id='input-firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input [@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input [@id='input-password']")
	WebElement txtpassword;
	
	
	@FindBy(xpath="//input [@id='input-confirm']")
	WebElement txtconfirmpassword;
	

	@FindBy(xpath="//input [@id='input-email']")
	WebElement txtemail;

	

	@FindBy(xpath="//input [@id='input-telephone']")
	WebElement txttelephone;


	
	@FindBy(xpath="//input [@name='agree']")
	WebElement btncheckboxpolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnbutton;
	
	@FindBy(xpath="//h1[.='Your Account Has Been Created!']")
	WebElement getconfirmationmesage;
	
	public void firstname(String frst)
	{
		txtfirstname.sendKeys(frst);
	}
	public void password(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	public void lastname(String last)
	{
		txtLastname.sendKeys(last);
	}
	public void confirmpassword(String cpwd)
	{
		txtconfirmpassword.sendKeys(cpwd);
	}

	public void email(String mail)
	{
		txtemail.sendKeys(mail);
	}
	public void telephone(String phone)
	{
		txttelephone.sendKeys(phone);
	}
	public void checkbox()
	{
		btncheckboxpolicy.click();
	}
	public void button()
	{
		btnbutton.click();
	}
	
	public String  registrationconfirmatio()
	{
	try
	{
		return getconfirmationmesage.getText();
	}
	catch(Exception e)
	{
		return(e.getMessage());
		
	}
	}}
	
	
	

