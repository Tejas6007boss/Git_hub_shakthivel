package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import object_repository.Homecart;
import object_repository.My_accountPage;
import object_repository.loginpage;
import testbase.base_class;

public class Tc_002  extends base_class
{
	 @Test(groups="Sanity")
	public void verifylogin()
	{
		 try {
			 
		 
		logger.info("*******Tc-002login test case*******");
		Homecart hp=new Homecart(driver);
		hp.clickMyaccount();
		hp.loginbtn();
		
		loginpage lp = new loginpage(driver);
		lp.clickMyemaildid(p.getProperty("email"));
		lp.clickMypasword(p.getProperty("password"));
		lp.clickMyloginbtn();
		//myaccount
		My_accountPage myacnt = new My_accountPage(driver);
		boolean target = myacnt.ismyaccountdisplayed();
		 
		 
		Assert.assertTrue(target);
		 }
		 catch(Exception e)
		 {
			 Assert.fail();
		 }
		logger.info("*******tc-002login test case passed*******");
		

		
	}
}
