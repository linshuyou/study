package selenium;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppDriver {
	private static final long timeouts = 5;
	private static AndroidDriver<WebElement> driver;
	
	public static void setDriver() {
//		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
		DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
//		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
//		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");
//		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//		desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\Documents\\Tencent Files\\1084066838\\FileRecv\\MobileFile\\bama_release_latest.apk");
		
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.philips.h2h.bama.beta.MainActivity");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.philips.h2h.bama.beta");
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		try {
			driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/**
	 * get driver
	 * @return AndroidDriver<WebElement>
	 * @author lin 2017年9月6日 下午8:53:03
	 */
	public static AndroidDriver<WebElement> getCurrentDriver() {
		return driver;
	}
	public static void main(String[] args) {
		AppDriver.setDriver();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppDriver.getCurrentDriver().quit();
	}
}
