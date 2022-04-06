package Test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.apache.poi.hssf.usermodel.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class AmazonLogin {
	
	public static WebDriver driver;
	public static Properties prop;
	public static String sAppURL;
	public static String username;
	public static String password;
	public static Actions actions;
	public static String readXL;
	
	public static String readXL(int row, String column, String strFilePath) throws IOException
	{
		
		File file =    new File("G:\\thinkQuotient\\AmazonProject\\Data\\SearchList.xls");
		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(inputStream);
		HSSFSheet sheet=wb.getSheet("location");
		HSSFRow row1=sheet.getRow(1);
				
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println(rowCount);
        
        for(int i=0;i<=rowCount;i++){
            
            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();
            System.out.println(cellcount);
            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");
            
            for(int j=0;j<cellcount;j++){
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +"");
            }
            System.out.println();
           
	System.out.print(sheet.getRow(1));
        return null;
	}
	}	
	
  @Test
  public void Login_Details() {

	 	actions.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
	  	driver.findElement(By.cssSelector("div[id='nav-flyout-ya-signin'] span[class='nav-action-inner']")).click();
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signInSubmit")).click();
			
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
	  password = prop.getProperty("password");
	  
	  System.setProperty("webdriver.chrome.driver","G:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
	
		driver.manage().window().maximize();
		driver.get(sAppURL);
  }

  @AfterTest
  public void afterTest() {
  }

}
