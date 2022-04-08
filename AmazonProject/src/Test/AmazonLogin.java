package Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AmazonLogin {
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String username;
	public static String password;
	public static Actions actions;
	public static String readXL1;
		
  @Test
  public void Login_Details() throws IOException 
	{
	  
	 	actions.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
	  	driver.findElement(By.cssSelector("div[id='nav-flyout-ya-signin'] span[class='nav-action-inner']")).click();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		//driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signInSubmit")).click();	
		String[] data = ExcelData.readXL1();
		System.out.println("Logged IN Succesfully");
		System.out.println('\n' + "Search Results for " + data[1]);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data[1]);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String Search11 = driver.findElement(By.xpath(
				"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]"))
				.getText();
		System.out.println('\n' + Search11);
		String Search12 = driver.findElement(By.xpath(
				"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]"))
				.getText();
		System.out.println('\n' + Search12);
		String Search13 = driver.findElement(By.xpath(
				"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3']//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']//span[1]"))
				.getText();
		System.out.println('\n' + Search13);
		String Search14 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_4'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search14);
		String Search15 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search15);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		System.out.println('\n' + "Search Results for " + data[2]);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data[2]);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String Search21 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search21);
		String Search22 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2'] h2[class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'] span:nth-child(1)"))
				.getText();
		System.out.println('\n' + Search22);
		String Search23 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3'] div[class='a-section a-spacing-none s-padding-right-small s-title-instructions-style'] span:nth-child(1)"))
				.getText();
		System.out.println('\n' + Search23);
		String Search24 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_4'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search24);
		String Search25 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5'] div[class='a-section a-spacing-none s-padding-right-small s-title-instructions-style'] span:nth-child(1)"))
				.getText();
		System.out.println('\n' + Search25);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		System.out.println('\n' + "Search Results for " + data[3]);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(data[3]);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String Search31 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search31);
		String Search32 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search32);
		String Search33 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_3'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search33);
		String Search34 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_4'] div[class='a-section a-spacing-none s-padding-right-small s-title-instructions-style'] span:nth-child(1)"))
				.getText();
		System.out.println('\n' + Search34);
		String Search35 = driver.findElement(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5'] span[class='a-size-medium a-color-base a-text-normal']"))
				.getText();
		System.out.println('\n' + Search35);
		driver.findElement(By.id("twotabsearchtextbox")).clear();
	}

		  @BeforeTest
		  public void beforeTest() throws FileNotFoundException, IOException {
			  try {
				  prop = new Properties();
			  }catch (Exception e) {
				  
				  e.printStackTrace();
			  }
			  prop.load(new FileInputStream("G:\\thinkQuotient\\AmazonProject\\Configuration\\Amazon_Configuration.properties"));
			  sAppURL = prop.getProperty("sAppURL");
			  username = prop.getProperty("username");
			  password = prop.getProperty("pwd");
			  
			  System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				actions = new Actions(driver);
			
				driver.manage().window().maximize();
				driver.get(sAppURL);
		  }
		  @AfterTest
		  public void afterTest() {
			  driver.quit();
		  }
		  
		}
