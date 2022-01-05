package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2DuplicateLead {

	public static void main(String[] args) throws InterruptedException {


		//Initial Setup
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
				// 1. Launch URL "http://leaftaps.com/opentaps/control/login
				driver.get("http://leaftaps.com/opentaps/control/main");
				
				// 2. Enter UserName
				driver.findElement(By.xpath("(//input[@id='username'])")).sendKeys("DemoCSR");
				
				// 3. Enter password
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
						
				// 4. Click on Login Button using Class Locator
				driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();
				
				// 5. Click on CRM/SFA Link
				driver.findElement(By.xpath("//div[@id = 'label']")).click();
				
				// 6. Click Leads link
				driver.findElement(By.linkText("Leads")).click();
				
				// 7. Click Find leads
				WebElement findLeads = driver.findElement(By.linkText("Find Leads"));
				findLeads.click();
				
				// 8. Click on Email
				driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
				
				// 9. Enter Email
				String email = "rinky.test@yopmail.com";
				WebElement emailTextbox = driver.findElement(By.xpath("//input[@name = 'emailAddress']"));
				emailTextbox.sendKeys(email);
				
				// 10. Click find leads button
				WebElement findLeadsButton = driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]"));
				findLeadsButton.click();
				Thread.sleep(2000);
				
				// 11. Capture name of First Resulting lead
				WebElement leadID = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a"));
				String text = leadID.getText();
				System.out.println("Lead ID is: " + text);
				
				Thread.sleep(2000);
				
				// 12. Click First Resulting lead
				leadID.click();
				
				// 13. Click Duplicate Lead
				driver.findElement(By.linkText("Duplicate Lead")).click();
				
				// 14. Verify the title as 'Duplicate Lead'
				WebElement title = driver.findElement(By.id("sectionHeaderTitle_leads"));
				String titleText = title.getText();
				 if (titleText.equalsIgnoreCase("Duplicate Lead")) {
					 System.out.println("Title verified successfully: " + titleText);
				 } else {
					 System.out.println("Title name mismatch");
				 }
				
				/*
				WebElement verifyEmail = driver.findElement(By.id("createLeadForm_primaryEmail"));
				String text2 = verifyEmail.getText();
				System.out.println(text2);
				
				if (text2.equalsIgnoreCase(text)) {
					System.out.println("Email is duplicate: " + text2);
				}
				*/
				
				// 15. Click Create Lead
				driver.findElement(By.xpath("//input[@name = 'submitButton']")).click();
				
				// 16. Confirm the duplicated lead name is same as captured name
				WebElement email1 = driver.findElement(By.xpath("//b[contains(text(),'Email Address')]/following::a[1]"));
				String emailText = email1.getText();
				System.out.println(emailText);
				
				if (emailText.equalsIgnoreCase(email)) {
					System.out.println("Email IDs are same");
				} else {
					 System.out.println("Email ID mismatch");
				}
				
				// 17. Close the browser (Do not log out)
				driver.close();
				
	}

}
