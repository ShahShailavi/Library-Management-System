import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchBook {

	public static void main(String[] args) throws InterruptedException {
		
		String projectLoction = System.getProperty("user.dir");
		
		//Launch Google chrome
		System.setProperty("webdriver.chrome.driver",projectLoction + "/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//PageLoadTimeOut which is dynamic timeout
		// This is for web page loading
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//implicit wait which is dynamic timeout
		//implicit wait is applied globally that is it is available for all the 
		//webelement which are available in page with whom driver is communicating
		//It can changed anywhere and anytime in out
		//We should never use explict and implicit wait together
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Launch URL
		driver.get("http://localhost:8080/LMS");
		
		//Define Elements
		WebElement firtName = driver.findElement(By.name("user_name"));
		WebElement lastName = driver.findElement(By.name("password"));
	
		//WebElement email = driver.findElement(By.name("reg_email__"));
		//WebElement passWord = driver.findElement(By.name("reg_passwd__"));
		
		
		
		
		//calling method for explicit wait
		sendKeys(driver, firtName, 10, "j");
		sendKeys(driver, lastName, 5, "j");
		driver.findElement(By.xpath("/html/body/div/div/section/div/form/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/section/aside/nav/ul/li[1]/a/span")).click();
		WebElement searchBook = driver.findElement(By.xpath("//*[@id='search']"));
		Thread.sleep(2000);
		sendKeys(driver, searchBook, 5, "treasure hunters");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div[1]/div[2]/section/div[2]/div/button")).click();
		Thread.sleep(5000);
		
		//sendKeys(driver, email, 5, "niket@gmail.com");
		//sendKeys(driver, passWord, 5, "123");
		
		driver.close();
		
	}
	
	
	//Explicit wait
	//1. no explicit keyword or method
	//2. Available with WebDriverWait with some expectedCondition (Interview Line)
	//3. Specific to element
	//4. Dynamic in natures
	// own custom method for sendKeys
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value){
		//explicit wait till visibility of particular element
		// No need to create new object just reference of WebDrivrWait
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	// click for birthday events
	public static void clickOn(WebDriver driver, WebElement element, int timeout, String value){
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	

}
