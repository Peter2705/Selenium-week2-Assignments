package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'account')]")).click();
		driver.findElement(By.name("firstname")).sendKeys("Peter");
		driver.findElement(By.name("lastname")).sendKeys("A");
		driver.findElement(By.name("reg_email__")).sendKeys("peterwinsly@yahoo.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Sak&win6");
		
		WebElement Day = driver.findElement(By.name("birthday_day"));
		Select day = new Select(Day);
		day.selectByIndex(2);
		
		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select month = new Select(Month);
		month.selectByVisibleText("Apr");
		
		WebElement Year = driver.findElement(By.name("birthday_year"));
		Select year = new Select(Year);
		year.selectByValue("1983");
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		String Title = driver.getTitle();
		System.out.println("Title of the page is :"+Title);
		
		driver.close();
	}

}
