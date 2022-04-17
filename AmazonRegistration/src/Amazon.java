import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
public class Amazon {
WebDriver driver;
		XSSFWorkbook wb = null;
		XSSFSheet sheet1;
		String ptitle1;
		File file;

		public void openBrowser() {

			try {

				System.setProperty("webdriver.chrome.driver",
						"G:\\Drivers\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // this line is mandatory: page
																					// synchronization
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// this line is mandatory: page
																					// synchronization

				driver.get("https://www.amazon.in/register");
				

				ptitle1 = driver.getTitle();

				System.out.println(" ptitle 1 " + ptitle1);

				searchItem();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void searchItem() {
			try {
				
				Thread.sleep(3000);
				getSheet();

				testData();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void getSheet() {
			try {
				file = new File("G:\\thinkQuotient\\AmazonProject\\Data\\SearchList.xls");
				FileInputStream fis = new FileInputStream(file);
				wb = new XSSFWorkbook(fis);
				sheet1 = wb.getSheetAt(0);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		public void testData() {
			String name = sheet1.getRow(i).getCell(j).getStringCellValue();
			
			String phStr = sheet1.getRow(0).getCell(1).getStringCellValue();
			String email = sheet1.getRow(0).getCell(2).getStringCellValue();
			String passwd = sheet1.getRow(0).getCell(3).getStringCellValue();

			try {
				driver.findElement(By.id("ap_customer_name")).sendKeys(name);
				Thread.sleep(1000);

				driver.findElement(By.id("ap_phone_number")).sendKeys(phStr);
				Thread.sleep(1000);
				driver.findElement(By.id("ap_email")).sendKeys(email);
				Thread.sleep(1000);
				driver.findElement(By.id("ap_password")).sendKeys(passwd);
				Thread.sleep(1000);

				driver.findElement(By.id("continue")).click();
				String errorText = driver.findElement(By.className("a-alert-content")).getText();

				System.out.println(" error " + errorText);

				XSSFCell cell = sheet1.getRow(0).createCell(4);
				if (errorText != null)

					cell.setCellValue("fail");

				else
					cell.setCellValue("pass");
				
				FileOutputStream fout = new FileOutputStream(file);
				wb.write(fout);

			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			finally {
				try {
					wb.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

		public static void main(String[] args) {
		Amazon a = new Amazon();

		a.openBrowser();
		}
	}

