package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



class SeleniumTest1 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	private WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		 driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@Disabled
	void test() throws InterruptedException {
		driver.get("https://www.google.com/"); // get()でブラウザ起動
		Thread.sleep(3000);
		// ブラウザの要素を指定 メソッド名がわかりやすいですよね。
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		WebElement firstLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.yuRUbf > a > h3"));
		// 処理を停止(動作確認の為)
		System.out.println(firstLink.getText());
		Thread.sleep(3000);
		assertEquals("Seleniumブラウザー自動化プロジェクト", firstLink.getText());
	}
	
	@Test
	@Disabled
	void test02() throws InterruptedException, IOException {
		driver.get("https://rakuplus.jp/"); // get()でブラウザ起動
		Thread.sleep(1000);
		WebElement userName = driver.findElement(By.name("log"));
		userName.sendKeys("");
		
		WebElement pass = driver.findElement(By.name("pwd"));
		pass.sendKeys("");
		
		driver.findElement(By.cssSelector("#wp-submit")).click();
		Thread.sleep(3000);
		
		 File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Files.copy(file.toPath(), new File("C:/env/"+file.getName()).toPath());
		 System.out.println(file.toPath());
	}
	
	@Test
	void test03() throws InterruptedException, IOException {
		driver.get("https://www.e-procurement.metro.tokyo.jp/"); // get()でブラウザ起動
		Thread.sleep(1000);
		
            //元のページのハンドルを記憶
            String Handle = driver.getWindowHandle();

            WebElement click = driver.findElement(By.cssSelector("#menu_1 > a > span"));
            click.click();
            Thread.sleep(2000);
            
            //次のタブのハンドルを用意し、タブが新しく開かれていたらnewHandleに代入する
            String newHandle = null;
            for (String id : driver.getWindowHandles()) {
                if (!id.equals(Handle)) {
                    newHandle = id;
                }
            }
            //newHandleにハンドルを移す
            driver.switchTo().window(newHandle);

       
		WebElement click2 = driver.findElement(By.cssSelector("#topMenuBtn03 > a"));
		click2.click();
		Thread.sleep(2000);
		
		WebElement year = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(2)"));
		year.sendKeys("3");
		WebElement month = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(3)"));
		month.sendKeys("11");
		WebElement day = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(4)"));
		day.sendKeys("15");
		
		WebElement year1 = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(7)"));
		year1.sendKeys("4");
		WebElement month1 = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(8)"));
		month1.sendKeys("11");
		WebElement day1 = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table.searchCond > tbody > tr:nth-child(17) > td > input[type=text]:nth-child(9)"));
		day1.sendKeys("30");
		Thread.sleep(2000);
		
		WebElement submit = driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a"));
		submit.click();
		Thread.sleep(2000);
		
		
		WebElement table = driver.findElement(By.cssSelector("table.list-data"));
		List<WebElement> trList = table.findElements(By.tagName("tr"));
		int i = 0;
		for(WebElement tr : trList) {
			if(i >= 1) {
				List<WebElement> tdList = tr.findElements(By.tagName("td"));
				System.out.println(tdList.get(0).getText()
						+"\t" +tdList.get(1).getText()
						+"\t" + tdList.get(2).getText());
			}
			i++;
		}
		

		
		
		
	}

}
