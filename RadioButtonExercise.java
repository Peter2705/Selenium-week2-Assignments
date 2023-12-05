package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonExercise {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//table[contains(@id,'console1')])//td[2]")).click();
		WebElement def = driver.findElement(By.xpath("(//table[contains(@id,'console2')])//div[contains(@class,'ui-state-active')]"));
		boolean state = def.isEnabled();
		System.out.println(state);
		if (state == true) {
			String text = driver.findElement(By.xpath("((//table[contains(@id,'console2')])//div[contains(@class,'ui-state-active')]/ancestor::td)/label")).getText();

			//String text = driver.findElement(By.xpath("("+def+"/ancestor::td)/label")).getText();
			System.out.println("The default radio button selected is :"+text);

		}
		else {
			System.out.println("No default radio button is selected");
		}
		WebElement age = driver.findElement(By.xpath("(//div[contains(@id,'age')])//div[contains(@class,'ui-state-active')]"));
		boolean state1=age.isEnabled();
		System.out.println(state1);
		
		if (state1 == true) {
			String text1 = driver.findElement(By.xpath("((//div[contains(@id,'age')])//div[contains(@class,'ui-state-active')]/ancestor::div)/label")).getText();
			System.out.println("The text in age selecvted is "+text1);
			
			if (text1.contains("21-40 Years")){
				
				System.out.println("The default radio button already selected is :"+text1);
			}
			else {
				driver.findElement(By.xpath("(//label[contains(text(),'21-40 Years')])/parent::div//div[contains(@class,'ui-radiobutton-box')]")).click();
			//	((//div[contains(@id,'age')])//div[contains(@class,'ui-radiobutton-box')])[2]
			}
			//String text = driver.findElement(By.xpath("("+def+"/ancestor::td)/label")).getText();
			

		}
		else {
			System.out.println("No default radio button is selected");
		}
		
		WebElement selectedstatus = driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]"));
		System.out.println(selectedstatus.isSelected());
		if (selectedstatus.isSelected()==false) {
			System.out.println("The city radio button is not selected");
			//select the radio button
			driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]")).click();
			//check if it is selected
			WebElement selectedstatus1 = driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]"));
			System.out.println(selectedstatus1.isEnabled());
			
			if (selectedstatus1.isEnabled()==true) {
				System.out.println("The city radio button is now selected");
				driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]")).click();
				
				WebElement selectedstatus2 = driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]"));
				System.out.println(selectedstatus2.isSelected());
				
				if (selectedstatus1.isSelected()==false) {
					System.out.println("The city radio button is not selected again");
					
				}
			}
		}
		else {
			System.out.println("The city radio button is selected");
			driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]")).click();
			//check if it is selected
			WebElement selectedstatus1 = driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]"));
			if (selectedstatus1.isEnabled()==false) {
				System.out.println("The city radio button is not selected");
				driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]")).click();
				
				WebElement selectedstatus2 = driver.findElement(By.xpath("((//div[contains(@id,'city2')])//div[contains(@class,'ui-radiobutton-box')])[1]"));
				if (selectedstatus1.isSelected()==true) {
					System.out.println("The city radio button is selected again");
					
				}
			}
		}
		
	}

}
