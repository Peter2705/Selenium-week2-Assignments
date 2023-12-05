package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.linkText("Create Account")).click();
		String name = "Sailesh";
		driver.findElement(By.id("accountName")).sendKeys(name);
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
		
		WebElement Ind = driver.findElement(By.name("industryEnumId"));
		Select ind = new Select(Ind);
		ind.selectByIndex(3);
		
		WebElement Ownership = driver.findElement(By.name("ownershipEnumId"));
		Select own = new Select(Ownership);
		own.selectByVisibleText("S-Corporation");
		
		WebElement Source = driver.findElement(By.id("dataSourceId"));
		Select src = new Select(Source);
		src.selectByValue("LEAD_EMPLOYEE");
		
		WebElement MarketCampaign = driver.findElement(By.id("marketingCampaignId"));
		Select markcamp = new Select(MarketCampaign);
		markcamp.selectByIndex(6);
		
		WebElement State = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select state = new Select(State);
		state.selectByValue("TX");
		
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(5000);
		
		WebElement AN = driver.findElement(By.xpath("(//tbody/tr/td[2]/span[@class='tabletext'])[1]"));
		String ActName = AN.getText();
		
		System.out.println(ActName);
		if (ActName.contains(name)) {
			System.out.println("Account created succesfully for "+ name);
		}
		else {
			System.out.println("Account not created succesfully");
		}
		
		driver.close();
	}

}
