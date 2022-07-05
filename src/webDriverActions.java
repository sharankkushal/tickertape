import java.math.BigDecimal;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;
import org.testng.annotations.AfterTest;

public class webDriverActions {

	protected WebDriver webDriver;
	public String parentWindow;
	private static final Duration TIMEOUT = Duration.ofSeconds(30);

	public webDriverActions(){
		//Please update the path of the driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Documents\\driver\\chromedriver.exe");
		webDriver = new ChromeDriver();
	}
	
	public WebDriver getWebDriver() {
		return webDriver;
	}
	
	public void openURL(String url) {
		webDriver.get(url);
		webDriver.manage().window().maximize();
	}
	
	public void waitForElementToBePresent(By by) {
		new WebDriverWait(webDriver, TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}
	
	public void waitForElementToBeVisible(By by) {
			new WebDriverWait(webDriver, TIMEOUT ).until(ExpectedConditions.visibilityOfElementLocated(by));
			
	}
	
	public void moveToElement(By by) {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(webDriver.findElement(by)).build().perform();
	}
	
	public void waitForElementToBeClickable(By by) {
		new WebDriverWait(webDriver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(by));

	}
	
	public void moveToTop() {
		((JavascriptExecutor) webDriver).executeScript("return window.scroll(0,0)");
	}
	
	public void moveToBottom() {
		((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void refreshPage() {
		webDriver.navigate().refresh();
	}
	
	public void sleep(int seconds){
		try {
			Thread.sleep((long) seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getText(By by) {
		try {
			waitForElementToBePresent(by);
			waitForElementToBeVisible(by);
			moveToElement(by);
			return webDriver.findElement(by).getText();
		} catch (NoSuchElementException ex) {
			waitForElementToBePresent(by);
			moveToElement(by);
			return webDriver.findElement(by).getText();
		}
	}
	
	public void click(By by) {
		try {
			waitForElementToBeVisible(by);
			moveToElement(by);
			waitForElementToBePresent(by);
			waitForElementToBeClickable(by);
			webDriver.findElement(by).click();
		} 
		catch (ElementNotInteractableException cinex) {
			sleep(1);
			moveToTop();
			waitForElementToBeVisible(by);
			moveToElement(by);
			waitForElementToBePresent(by);
			waitForElementToBeClickable(by);
			webDriver.findElement(by).click();
		}
	}
	
	public void clearAndType(By by, String text)  {
			click(by);
			webDriver.findElement(by).clear();
			webDriver.findElement(by).sendKeys(text);
	}
	
	public void type(By by, String text)  {
		try {
			click(by);
			webDriver.findElement(by).sendKeys(text);
		} catch (NoSuchElementException nsex) {
			nsex.printStackTrace();
		}
	}
	
	public void enter(By by) {
		webDriver.findElement(by).sendKeys(Keys.ENTER);
	}
	
	public void waitForElementToLoad(By by, int timeout, String element) {
		try {
			Wait<WebDriver> wait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(timeout))
					.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

			wait.until(webDriver -> webDriver.findElement(by));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void switchToWindow() {
		parentWindow = webDriver.getWindowHandle();
		for (String winHandle : webDriver.getWindowHandles()) {
			webDriver.switchTo().window(winHandle);
		}
	}


	public void stopSelenium() {
		webDriver.close();
		webDriver.quit();
	}
	public static BigDecimal convertStringToBigDecimal(String stringValue) {
		stringValue = stringValue.trim();
		if ((stringValue != null && stringValue.trim().length() > 0)) {
			return new BigDecimal(stringValue.replaceAll(",", "").trim());
		} else {
			return new BigDecimal(0);
		}
	}

	public int compareTwoCurrencyString(String price1, String price2) {
		BigDecimal priceOne = convertStringToBigDecimal(price1);
		BigDecimal priceTwo = convertStringToBigDecimal(price2);
		return priceOne.compareTo(priceTwo);
	}
	

	
	
	
}
