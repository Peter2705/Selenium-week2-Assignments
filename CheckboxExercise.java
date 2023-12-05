package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxExercise {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox')])[1]/div[2]")).click();
		driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox')])[2]/div[2]")).click();
		String exptext = driver.findElement(By.xpath("//span[contains(text(),'Checked')]")).getText();
		System.out.println(exptext);
		if(exptext.contains("Checked")) {
		System.out.println("The Notification box is "+exptext);
		}
		else {
			System.out.println("The Notification box is not "+exptext);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-selectmanycheckbox ui-widget']//td[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget'])[6]")).click();
		String state = driver.findElement(By.xpath("(//span[contains(text(),'State')])/following-sibling::p")).getText();
		System.out.println("The Tristate option selected is "+state);
		Thread.sleep(2000);
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		String exptext1 = driver.findElement(By.xpath("//span[contains(text(),'Checked')]")).getText();
		if(exptext1.contains("Checked")) {
			System.out.println("The Toggleswitch is "+exptext1);
			}
			else {
				System.out.println("The Toggleswitch is not "+exptext1);
			}
		Thread.sleep(2000);
		WebElement dis = driver.findElement(By.xpath("(//div[contains(@class,'ui-selectbooleancheckbox')])[3]//div[2]"));
		Boolean status = dis.isSelected();
		System.out.println("The status is "+status);
		if (status == false) {
			System.out.println("Checkbox is disabled");
		}
		else {
			System.out.println("Checkbox is enabled");
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-multiple')]")).click();
		List<WebElement> multiple = driver.findElements(By.xpath("(//*[contains(@class,'selectcheckboxmenu-unchecked')])//div[2]"));
		multiple.get(1).click();
		multiple.get(3).click();
		driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-multiple')]")).click();
		
		driver.close();
	}

}
