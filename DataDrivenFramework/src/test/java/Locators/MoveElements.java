package Locators;

import java.awt.Robot;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MoveElements {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		Actions actions=new Actions(driver);
		WebElement Desktops=driver.findElement(By.linkText("Desktops"));
		WebElement PC=driver.findElement(By.linkText("Tablets"));
		WebElement search=driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		//driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.id("input-email")).sendKeys("arun");
		
		//actions.keyDown(Keys.TAB).pause(1).perform();
		//actions.keyDown(Keys.ENTER).perform();
		WebElement title=driver.findElement(By.linkText("Qafox.com"));
		//actions.moveToElement(Desktops).moveToElement(PC).click().build().perform();
		
		File srcfile=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcfile, new File("./Screenshot/full.png"));
		Thread.sleep(10000);
		driver.quit();
		
	}

}
