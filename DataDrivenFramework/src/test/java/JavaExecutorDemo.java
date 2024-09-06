import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

public class JavaExecutorDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
ChromeDriver driver=new ChromeDriver();
JavascriptExecutor jse=driver;
//driver.get("https://www.google.com");
driver.navigate().to("https://tutorialsninja.com/demo/");
WebElement Button1=driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
//JavascriptExecutor jse=driver;
jse.executeScript("arguments[0].style.background='green'",Button1);
String title=jse.executeScript("return document.title").toString();
System.out.println("title of the Page is"+title);


//driver.executeScript("document.getElementById('input-");
Thread.sleep(4000);
driver.quit();
	}

}
