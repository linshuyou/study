package selenium;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class AppDriver {
	private static final long timeouts = 5;
	private static AndroidDriver<WebElement> driver;
	
	public enum appName {
		setting,bama
	}
	public static void setDriver(appName app) {
		DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
//		desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
//		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
//		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "5000");
		desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//		desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
//		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Administrator\\Documents\\Tencent Files\\1084066838\\FileRecv\\MobileFile\\bama_release_latest.apk");
		switch (app) {
		case setting:
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.HWSettings");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.settings");
			break;
		case bama:
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.philips.h2h.bama.beta.MainActivity");
			desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.philips.h2h.bama.beta");
			break;
		default:
			System.out.println("error: appName not found");
			break;
		}
		
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
		desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
		try {
			driver=new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
	}
	/**
	 * get driver
	 * @return AndroidDriver<WebElement>
	 * @author lin 2017年9月6日 下午8:53:03
	 */
	public static AndroidDriver<WebElement> getCurrentDriver() {
		return driver;
	}
	/** 
	 * wait For Page Loaded by a loaded flag disappear
	 * @author lin 2017年9月19日 下午10:22:43
	 */
	public static void waitForPageLoaded() {
		try {
//			new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/**
	 * find element by By
	 * @param by
	 * @return
	 * @author lin 2017年9月19日 下午10:24:31
	 */
	public static WebElement findElement(By by) {
		waitForPageLoaded();
		try {
			return driver.findElement(by);
		} catch (NoSuchElementException  e) {
			// TODO: handle exception
			System.out.println("NoSuchElementException:"+'\n'+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception:"+'\n'+e.getMessage());
		}
		return null;
		
	}
	/**
	 * find elements by By return java.util.List
	 * @param by
	 * @return
	 * @author lin 2017年9月20日 上午12:07:51
	 */
	public static List<WebElement> findElements(By by) {
		waitForPageLoaded();
		try {
			return driver.findElements(by);
		} catch (NoSuchElementException  e) {
			// TODO: handle exception
			System.out.println("NoSuchElementException:"+'\n'+e.getMessage());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception:"+'\n'+e.getMessage());
		}
		return null;
	}
	/**
	 * wait For Element Visible
	 * @param by
	 * @return
	 * @author lin 2017年9月19日 下午10:25:39
	 */
	public static boolean waitForElementVisible(By by) {
		return waitForElementVisible(findElement(by));
	}
	/**
	 * wait For Element Visible
	 * @param element
	 * @return
	 * @author lin 2017年9月19日 下午10:25:43
	 */
	public static boolean waitForElementVisible(WebElement element) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
			return true;
		}catch (TimeoutException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	/**
	 * wait For Element invisible
	 * @param by
	 * @return
	 * @author lin 2017年9月19日 下午10:27:01
	 */
	public static boolean waitForElementInvisible(By by) {
		return waitForElementInvisible(findElement(by));
	}
	/**
	 * wait For Element invisible
	 * @param element
	 * @return
	 * @author lin 2017年9月19日 下午10:26:47
	 */
	public static boolean waitForElementInvisible(WebElement element) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOf(element));
			return true;
		}catch (TimeoutException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	/**
	 * wait For Element Click-able by By
	 * @param by
	 * @return
	 * @author lin 2017年9月19日 下午10:27:40
	 */
	public static boolean waitForElementClickable(By by) {
		return waitForElementClickable(findElement(by));
	}
	/**
	 * wait For Element Click-able
	 * @param element
	 * @return
	 * @author lin 2017年9月19日 下午10:27:25
	 */
	public static boolean waitForElementClickable(WebElement element) {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
			return true;
		}catch (TimeoutException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
	/**
	 * click element by By
	 * @param by
	 * @author lin 2017年9月19日 下午10:29:01
	 */
	public static void click(By by) {
		click(findElement(by));
	}
	/**
	 * click element
	 * @param element
	 * @author lin 2017年9月19日 下午10:29:11
	 */
	public static void click(WebElement element) {
		if(!waitForElementClickable(element)) return;
		try {
			element.click();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	/**
	 * send keys by By
	 * @param by
	 * @param str
	 * @author lin 2017年9月19日 下午10:29:32
	 */
	public static void sendKeys(By by , String str) {
		sendKeys(findElement(by), str);
	}
	/**
	 * send keys
	 * @param element
	 * @param str
	 * @author lin 2017年9月19日 下午10:29:53
	 */
	public static void sendKeys(WebElement element , String str) {
		element.sendKeys(str);
	}
	
	public static void main(String[] args) {
		AppDriver.setDriver(appName.setting);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AppDriver.getCurrentDriver().quit();
	}
}
