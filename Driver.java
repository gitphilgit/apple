import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver extends DBConnect{
		
	
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\phil\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();							
		driver.navigate().to(Constants.strWebsite);		
	
		connect();
		
		//login test
		WebElement element = driver.findElement(By.id("username-input"));
		element.sendKeys(strUser);
		element = driver.findElement(By.id("password-input"));
		element.sendKeys(strPassword);
		element = driver.findElement(By.id("submit-button"));
		element.click();
		
	}

}
