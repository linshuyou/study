package test.app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.AppDriver;
import selenium.AppDriver.appName;

public class Bamatest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AppDriver.setDriver(appName.bama);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		AppDriver.getCurrentDriver().quit();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(AppDriver.getCurrentDriver().getContext());
		System.out.println(AppDriver.getCurrentDriver().getContextHandles());
		
		String ss="//*[@id=\"security-login-input-username\"]";
		WebElement element= AppDriver.findElement(By.xpath(ss));
		AppDriver.sendKeys(element, "123");
		String str=element.getAttribute("value");
		System.out.println(str);
	}

}
