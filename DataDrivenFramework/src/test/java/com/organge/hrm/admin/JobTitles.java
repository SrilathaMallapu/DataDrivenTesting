package com.organge.hrm.admin;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class JobTitles {
	
	WebDriver driver=new ChromeDriver();
	@Test
	public void invalid_Test() throws Exception
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span")).click();
		driver.findElement(By.linkText("Job Titles")).click();
		driver.findElement(By.xpath("(//h6/following::div/following::button)[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Add Job Title']")).isDisplayed());
		//Assert.assertEquals(driver.findElement(By.xpath("(//input)[2]")).getText(),"value","Please enter the value");
		driver.findElement(By.xpath("(//input)[2]")).sendKeys("Manager");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Browse']")).click();
		Thread.sleep(2000);
		Robot rb = new Robot();
		 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\Haritha\\Downloads\\Manager.txt");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(2000);
		driver.close();
	}

}
