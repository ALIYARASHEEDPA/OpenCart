package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import testBase.BaseClass;
import utilities.*;

public class Tc_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
public void test_loginddt(String email,String password,String exp)
{
logger.info("***Tc_003_LoginDDT***");
Homepage hp=new Homepage(driver);

hp.clicklogin();
//logger.info("clicked on login link and page is visible");

Loginpage lp=new Loginpage(driver);
lp.enteremail(email);
lp.enterpassword(password);

lp.clicklogin();

logger.info("clicked on login button");

MyAccountPage macc=new MyAccountPage(driver);
boolean targetpage=macc.verifylogin();


if(exp.equals("valid"))
    {
	  if(targetpage==true)
	  {
		  macc.Clicklogout();
		  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.fail();
	  }
	}
if(exp.equals("invalid"))
    {
	if(targetpage==true)
	{
		macc.Clicklogout();
		Assert.fail();
	}
	else
	{
		Assert.assertTrue(true);
	}
	}

//Assert.assertEquals(targetpage,true);

}


}