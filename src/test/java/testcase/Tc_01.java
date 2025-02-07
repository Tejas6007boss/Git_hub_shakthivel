package testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import object_repository.Account_Registration_page;
import object_repository.Homecart;
import testbase.base_class;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Tc_01   extends base_class
{
@Test(groups="Sanity")

	
public void verifyaccount()
{
	try {
	Homecart hp = new Homecart(driver);
	Account_Registration_page accnt = new Account_Registration_page(driver);
	
	hp.clickMyaccount();
    logger.info("**Clicked my account link**");
    hp.clickregister();

   // Account_Registration_page accnt = new Account_Registration_page(driver);
    logger.info("**Providing customer details**");
    accnt.firstname(randomeString1().toUpperCase());
    accnt.lastname(randomeString1().toUpperCase());
    accnt.email(randomeString1() + "@gmail.com");
    accnt.telephone(randomenumber2());
    String password1 = randomealphanumeric1();
    accnt.password(password1);
    accnt.confirmpassword(password1);
    logger.info("*entered Apssword*");
    accnt.checkbox();
    accnt.button();

    logger.info("**Validating expected message**");
    String cnfrm = accnt.registrationconfirmatio();
    Assert.assertEquals(cnfrm, "Your Account Has Been Created!", "Confirmation message mismatch!");

}
catch (Exception e) 
{
    logger.error("Test failed due to an exception: " + e.getMessage(), e);
    Assert.fail("Test failed due to an exception");
}
}

@AfterClass
public void tearDown() {
// Close the browser and perform cleanup actions
if (driver != null) {
    driver.quit();
    logger.info("**WebDriver closed**");
}
}
	

}