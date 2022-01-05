package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3Acme {

	public static void main(String[] args) {
		
		// Browser setup
		WebDriverManager.chromedriver().setup();
		
		// Launch browser
		ChromeDriver driver = new ChromeDriver();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Load URL
		driver.get("https://acme-test.uipath.com/login");
		
		// Enter Email
		WebElement email = driver.findElement(By.xpath("//input[contains(@id,'email')]"));
		email.clear();
		email.sendKeys("kumar.testleaf@gmail.com");
		
		// Enter Password
		WebElement password = driver.findElement(By.xpath("//input[contains(@id,'password')]"));
		password.clear();
		password.sendKeys("leaf@12");
		
		// Click login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		// Get the title of the page and print
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		
		// Log out
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
		
		// Close browser
		driver.close();

	}

}
