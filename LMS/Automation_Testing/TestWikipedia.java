import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWikipedia {

	public static void main(String[] args) throws InterruptedException {
		
		//Get project Location
		String projectLoction = System.getProperty("user.dir");
		
		//Launch Google chrome
		System.setProperty("webdriver.chrome.driver",projectLoction + "/ChromeDriver/chromedriver.exe");
		
		// Create Driver object with datatype WebDriver
		WebDriver driver = new ChromeDriver();
		
		// Negivate to wikipedia main website
		driver.get("https://www.wikipedia.org");
		
		//Create a reference for English text
		//click on English so I need to reference it
		//Create link Object with datatype WebElement is required
		//As text is static we use it by linkText method
		WebElement link;
		link = driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong"));
		
		//Click on the link
		link.click();
		
		//wait for a seconds
		Thread.sleep(5000);
		
		//Create a reference for search text box
		WebElement searchBox;
		searchBox = driver.findElement(By.id("searchInput"));
		
		//write inside the search box text
		searchBox.sendKeys("Software");
		searchBox.submit();
		
		//wait for some time
		Thread.sleep(5000);
		
		//close browser instance of web driver
		driver.quit();
	}

}
