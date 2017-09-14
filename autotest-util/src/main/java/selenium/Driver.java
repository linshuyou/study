package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	private static final long timeouts = 5;
	private static WebDriver driver;
	
	public Driver() {
		System.out.println("init...zZ");
	}
	public static void setDriver() {
		//如果火狐浏览器没有默认安装在C盘，需要制定其路径
//      System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
      //定义驱动对象为 FirefoxDriver 对象
//		System.setProperty("webdriver.chrome.driver", "././././././chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeouts, TimeUnit.SECONDS);
	}
	/**
	 * get driver
	 * @return WebDriver
	 */
	public static WebDriver getCurrentDriver() {
		return driver;
	}
	/**
	 * wait For Page Loaded by a loaded flag disappear
	 * @author lin 2017年9月7日 下午10:09:55
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
	 * 
	 * @param by
	 * @return WebElement
	 * @author lin 2017年9月6日 下午8:52:10
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
	 * wait For Element Visible
	 * @param by
	 * @return boolean true is find , otherwise
	 * @author lin 2017年9月6日 下午10:40:56
	 */
	public static boolean waitForElementVisible(By by) {
		return waitForElementVisible(findElement(by));
	}
	/**
	 * wait For Element Visible
	 * @param element
	 * @return boolean
	 * @author lin 2017年9月6日 下午10:44:11
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
	 * wait For Element Invisible
	 * @param by
	 * @return boolean
	 * @author lin 2017年9月7日 下午8:48:54
	 */
	public static boolean waitForElementInvisible(By by) {
		return waitForElementInvisible(findElement(by));
	}
	/**
	 * wait For Element invisible
	 * @param element
	 * @return boolean
	 * @author lin 2017年9月7日 下午8:47:57
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
	 * @return boolean
	 * @author lin 2017年9月6日 下午11:40:58
	 */
	public static boolean waitForElementClickable(By by) {
		return waitForElementClickable(findElement(by));
	}
	/**
	 * wait For Element Click-able
	 * @param element
	 * @return boolean
	 * @author lin 2017年9月6日 下午11:34:21
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
	 * @author lin 2017年9月6日 下午11:26:58
	 */
	public static void click(By by) {
		click(findElement(by));
	}
	/**
	 * click element
	 * @param element
	 * @author lin 2017年9月6日 下午11:59:40
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
	 * @author lin 2017年9月7日 上午12:01:04
	 */
	public static void sendKeys(By by , String str) {
		sendKeys(findElement(by), str);
	}
	/**
	 * send keys
	 * @param element
	 * @param str void
	 * @author lin 2017年9月7日 上午12:07:15
	 */
	public static void sendKeys(WebElement element , String str) {
		element.sendKeys(str);
	}
	/**
	 * main
	 * @param args void
	 * @author lin 2017年9月7日 下午8:11:10
	 */
	public static void main(String[] args) {
		setDriver();
		Driver.getCurrentDriver().get("https://www.baidu.com/");
		try {
			Driver.sendKeys(By.xpath("//*[@id=\"kw\"]"),"hahhaha");
			Driver.click(By.xpath("//*[@id=\"su\"]"));
//			Driver.waituntill(By.id("123211241341513414"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
//		WebElement element= Driver.findElement(By.xpath(null));
//		element.findElement(By.xpath(null));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver);
		Driver.getCurrentDriver().quit();

	}
}
