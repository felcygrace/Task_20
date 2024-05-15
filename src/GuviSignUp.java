import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GuviSignUp {
	public GuviSignUp() {
		//set system property for the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\FELCY\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	}

	public static void main(String[] args) {
		        // launch Browser
				WebDriver driver = new ChromeDriver();
				//Navigating the URL
				driver.navigate().to("https://www.guvi.in/");
				
				//Using ImplicitlyWait for page to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
				//Clicking SignUp button
				driver.findElement(By.xpath("(//a[text()='Sign up'])[1]")).click();
				
				//Input for SignUp Page
				driver.findElement(By.className("form-control")).sendKeys("Felcy S");
				driver.findElement(By.id("email")).sendKeys("felcygrace001@gmail.com");
				driver.findElement(By.cssSelector("input#password")).sendKeys("Felcy@12s");
				driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("6381698553");
				
				List<WebElement> signup = driver.findElements(By.tagName("a"));
		        for (WebElement signup1 : signup) 
		        {
					if (signup1.getAttribute("id").equals("signup-btn")) 
					{
						signup1.click();
					}
				}
		      //Using ImplicitlyWait for page to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				//Navigate to the URL
				driver.navigate().to("https://www.guvi.in/");
				
				//Using ImplicitlyWait to wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				//Clicking Login button
				driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
				
				//Input for Login Page
				driver.findElement(By.id("email")).sendKeys("felcygrace001@gmail.com");
				driver.findElement(By.id("password")).sendKeys("Felcy@12s");
				driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();

				//Using ExplicitWait to wait
				WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				Wait.until(ExpectedConditions.titleContains("GUVI | courses"));
				
				//To verify the page
				String verify = driver.getTitle();
			    System.out.println("Current Page: " +verify);
			    
		        if (verify.equals("GUVI | courses")) 
		        {
					System.out.println("Guvi Login Success");
				} 
		        else 
		        {
					System.out.println("Guvi Login Failed");
				}

		        //Closing the driver
		        driver.close();
	}

}