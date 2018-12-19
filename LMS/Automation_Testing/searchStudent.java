import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchStudent {

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
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/section/aside/nav/ul/li[4]/a/span")).click();
		WebElement searchStudent = driver.findElement(By.xpath("//*[@id='search']"));
		Thread.sleep(2000);
		sendKeys(driver, searchStudent, 5, "Van Kenneth");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div[1]/div[2]/section/div[2]/div/button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div[1]/div[1]/a[1]")).click();
		
		WebElement admissionNumber = driver.findElement(By.name("admission_no"));
		Thread.sleep(1000);
		WebElement studentName = driver.findElement(By.name("student_name"));
		Thread.sleep(1000);
		WebElement grade = driver.findElement(By.name("grade"));
		Thread.sleep(1000);
		WebElement section = driver.findElement(By.name("section"));
		Thread.sleep(1000);
		WebElement profile = driver.findElement(By.name("profile"));
		Thread.sleep(1000);
		
		sendKeys(driver, admissionNumber, 10, "7365");
		Thread.sleep(2000);
		sendKeys(driver, studentName, 5, "Shailavi");
		Thread.sleep(2000);
		sendKeys(driver, grade, 5, "A");
		Thread.sleep(2000);
		sendKeys(driver, section, 5, "542");
		Thread.sleep(2000);
		sendKeys(driver, profile, 5, "Study");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div/div[2]/section/div[2]/div/button")).click();
		Thread.sleep(5000);
		//sendKeys(driver, email, 5, "niket@gmail.com");
		//sendKeys(driver, passWord, 5, "123");
driver.findElement(By.xpath("/html/body/div[1]/section/section/div[1]/div[1]/a[1]")).click();
		
		WebElement admissionNumber1 = driver.findElement(By.name("admission_no"));
		Thread.sleep(5000);
		WebElement studentName1 = driver.findElement(By.name("student_name"));
		Thread.sleep(2000);
		WebElement grade1 = driver.findElement(By.name("grade"));
		Thread.sleep(2000);
		WebElement section1 = driver.findElement(By.name("section"));
		Thread.sleep(2000);
		WebElement profile1 = driver.findElement(By.name("profile"));
		Thread.sleep(2000);
		
		sendKeys(driver, admissionNumber1, 10, "13");
		Thread.sleep(2000);
		sendKeys(driver, studentName1, 5, "Shailavi");
		Thread.sleep(2000);
		sendKeys(driver, grade1, 5, "A");
		Thread.sleep(2000);
		sendKeys(driver, section1, 5, "542");
		Thread.sleep(2000);
		sendKeys(driver, profile1, 5, "Software verification and validation");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div/div[2]/section/div[2]/div/button")).click();
		Thread.sleep(7000);
		
		driver.findElement(By.xpath("/html/body/div[1]/section/aside/nav/ul/li[4]/a/span")).click();
		WebElement searchStudent1 = driver.findElement(By.xpath("//*[@id='search']"));
		Thread.sleep(2000);
		sendKeys(driver, searchStudent1, 5, "Shailavi");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/section/section/div[1]/div[2]/section/div[2]/div/button")).click();
		Thread.sleep(7000);
		
		
		
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
