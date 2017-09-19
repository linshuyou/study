package test.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.AppDriver;
import selenium.AppDriver.appName;

public class Setting {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		AppDriver.setDriver(appName.setting);
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
		List<WebElement> list= AppDriver.findElements(By.id("android:id/title"));
		for (WebElement webElement : list) {
			System.out.println(webElement.getText());
			System.out.println(webElement.getLocation());
			if(webElement.getText().equals("WLAN")) {
				AppDriver.click(webElement);
				break;
			}
		}
		
//		AppDriver.click(list.get(2));
//		AppDriver.click(By.id("android:id/summary"));
//		AppDriver.click(By.id("android:id/switch_widget"));
		System.out.println("123");
	}

}
