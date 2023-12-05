package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("99");
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(2000);
		String id = driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).getText();
		System.out.println(id);
		driver.findElement(By.xpath("(//table/tbody/tr/td/div/a)[1]")).click();
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.name("id")).sendKeys(id);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//div[contains(text(),'No records')]")).getText();
		String expText = "No records to display";
		System.out.println("The message is :"+text);
		if (text.equals(expText)) {
			System.out.println("The lead "+id+" deleted successfully");
		}
		else {
			System.out.println("The Lead "+id+" not deleted successfully");
		}
		
		driver.close();
	}

}
