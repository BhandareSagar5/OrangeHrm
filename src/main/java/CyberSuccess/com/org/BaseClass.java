package CyberSuccess.com.org;
	
	import java.time.Duration;
	import java.util.Random;
	import java.util.function.Function;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		public static WebDriver driver = null;
		public static void getBrowserInstance(String browser) {
			switch(browser) {
			
			case "Chrome" :
				//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
				
			case "Edge" :
				//System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				
			case "Firefox" :
				//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
				
			default:
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		}
		
		public static void validate (String actual, String expected) throws Exception {
			if(actual.equals(expected)) {
				System.out.println("Successfully validated " + actual + "in the screen");
			} else {
				throw new Exception ("Failed to validate the"+ actual + " with "+ expected);
			}
		}
		
		public static void validate (int actual, int expected) throws Exception {
			if (actual == expected) {
				System.out.println("Successfully validated " + actual + " tv on the screen");
			}
			else {
				throw new Exception ("Failed to validate the"+ actual + " with "+ expected);
			}
		}
		
		public static String generateRandomString(int count) {
			
			Random random = new Random();
			
			return random.ints(65, 91).limit(count)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();
		}
		
		@SuppressWarnings("unchecked")
		public static void fluientWait(By by) {
			
			Wait wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
			
			wait.until(new Function<WebDriver, WebElement>(){
				@Override
				public WebElement apply(WebDriver driver) {
					System.out.println("Applying fluent wait....");
					return driver.findElement(by);
				}
			});
		}
		
		
		
		
	}



