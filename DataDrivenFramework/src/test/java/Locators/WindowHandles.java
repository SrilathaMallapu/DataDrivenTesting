package Locators;

import java.awt.Window;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WindowHandles {
static WebDriver driver;
static Set<String> Windows;
public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		driver=new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		driver.manage().timeouts().pageLoadTimeout((Duration.ofSeconds(30)));
		String ParentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/a[4]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/a/div")).click();

	   Thread.sleep(3000);
	    Windows=driver.getWindowHandles();
	   getWindow("SpiceClub - The frequent flyer program of SpiceJet");
	  
	   driver.switchTo().newWindow(WindowType.TAB);
	   driver.get("https://www.google.com");
	   driver.switchTo().window(ParentWindow);
	   Thread.sleep(1000);
	  /* while(itr.hasNext())
	   {
		   String Windowid=itr.next();
		   driver.switchTo().window(Windowid);
		   System.out.println(driver.getTitle());
		   /*if(driver.getTitle().equals("SpiceClub - The frequent flyer program of SpiceJet"))
		   {
		   System.out.println(driver.getTitle());
	
		   }*/
		   
		 
	 
	   
	   
		System.out.println(driver.getTitle());
		driver.quit();
	}
public static void getWindow(String title) throws InterruptedException
{
	Iterator<String> itr=Windows.iterator();
	   while(itr.hasNext())
	   {
		   String Windowid=itr.next();
		   driver.switchTo().window(Windowid);
		
		   if(driver.getTitle().equals("SpiceClub - The frequent flyer program of SpiceJet"))
		   {
		   System.out.println(driver.getTitle());
		  WebElement dropdown= driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/select"));
	Select drop=new Select(dropdown);
	drop.selectByVisibleText("Mr");
	Thread.sleep(10000);
		  break;
		   }
		   
		
	   }
	   
}
}
