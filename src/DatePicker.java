import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		//Using Edge Browser Instead of Chrome 
		WebDriver driver = new EdgeDriver();

		//Maximizing the window 
		driver.manage().window().maximize();
		
		//Navigate to the URL
		driver.get("https://jqueryui.com/datepicker/");

		//Using ImplicitlyWait to wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Using switchTo frame to locate the element
		driver.switchTo().frame(0);
		
		//For clicking the next
		driver.findElement(By.id("datepicker")).click();
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();

		//Picking the date 22
		driver.findElement(By.xpath("((//table)[1]//tr//a[text()='22'])")).click();
		
		//Getting the date using getAttribute
		WebElement datePick = driver.findElement(By.id("datepicker"));
		String date = datePick.getAttribute("value");
		
		//Printing the date
		System.out.println("Next Month Date: " + date);

		//closing the driver
		driver.close();
	}

}