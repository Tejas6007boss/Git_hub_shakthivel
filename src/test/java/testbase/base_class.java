package testbase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import freemarker.template.SimpleDate;

	public class base_class 
	{
		public static WebDriver  	driver;
		public Logger logger;//log4j import apache package
		public Properties p;

		@BeforeClass(groups="Sanity")
@Parameters({"os","browser"})
		public 	void setup(String os,String br) throws IOException
			{
FileReader file=new FileReader("./src//test//resources//config.properties");
p=new Properties();
p.load(file);


			//loading config.property files
				logger=LogManager.getLogger(this.getClass());
switch(br.toLowerCase())
{
case"chrome":driver=new ChromeDriver();break;
case"firefox":driver=new FirefoxDriver();break;

}

			driver=new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(p.getProperty("url"));
			
			driver.manage().window().maximize();

			}
		@AfterClass(groups="Sanity")

		public 	void tardown()
			{
				driver.quit();
			}
		public String   randomeString1()
		{
			String genrtd = RandomStringUtils.randomAlphabetic(5);
			return genrtd;

		}
		public String   randomenumber2()
		{
			String genrtdnumb = RandomStringUtils.randomNumeric(10);
			return genrtdnumb;

		}
		public String   randomealphanumeric1()
		{
			String genertedstring = RandomStringUtils.randomAlphabetic(3);
			String genrtdnumb = RandomStringUtils.randomNumeric(3);

			return (genertedstring+genrtdnumb);

		}
		public String capture(String tname)
		{
			String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
			File src = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String targetfilepath = System.getProperty("\\screenshots\\"+tname+"_"+ timestamp+".png");
			File targetFile = new File(targetfilepath);
			src.renameTo(targetFile);
			return targetfilepath;
			
		}
	}




