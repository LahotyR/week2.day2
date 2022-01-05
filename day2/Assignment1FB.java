package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1FB {

	public static void main(String[] args) {
		
		// Step 1: Download and set the path
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Rinky");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("Test");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email address')]")).sendKeys("1234567890");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[contains(@aria-label,'New password')]")).sendKeys("Abc@12345");
		
		// Step 11: Handle all the three drop downs for DOB
		WebElement day = driver.findElement(By.xpath("//select[@id = 'day']"));
		WebElement month = driver.findElement(By.xpath("//select[@id = 'month']"));
		WebElement year = driver.findElement(By.xpath("//select[@id = 'year']"));
		
		Select dropdown1 = new Select(day);
		Select dropdown2 = new Select(month);
		Select dropdown3 = new Select(year);
		
		int size = dropdown2.getOptions().size();
		
		dropdown1.selectByVisibleText("9");
		dropdown2.selectByIndex(size-6);
		dropdown3.selectByValue("2000");
		
		// Step 12: Select the radio button "Female" ( A normal click will do for this step)
		WebElement gender = driver.findElement(By.xpath("//div[contains(text(),'Gender')]/following-sibling::span//label[contains(text(),'Custom')]"));
		gender.click();
		
		// Select your pronoun
		WebElement pronoun = driver.findElement(By.xpath("//select[@aria-label='Select your pronoun']"));
		Select dropdown4 = new Select(pronoun);
		dropdown4.selectByValue("6");
		
		// Close browser window
		driver.close();
		
		
	}

}
