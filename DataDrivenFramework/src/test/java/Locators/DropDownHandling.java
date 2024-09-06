package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://tutorialsninja.com/demo/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
driver.findElement(By.linkText("Login")).click();
driver.findElement(By.linkText("Forgotten Password")).click();
driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("Hasni@gmail.com");
driver.findElement(By.xpath("//div[@class='pull-right']/input")).click();
String text = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
//String text = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

System.out.println(text);
driver.quit();
	}

}
