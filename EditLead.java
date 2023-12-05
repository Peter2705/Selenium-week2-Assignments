package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Virtusa");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Winsly");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("A");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("VIRPET");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Finance");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is Test Description");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Abc@yahoo.com");
		
		WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(State);
		state.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("This is default note");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(4000);
		String Title = driver.getTitle();
		System.out.println("The title of the page is :"+Title);
		
		driver.close();

	}

}
