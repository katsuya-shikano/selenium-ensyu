package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		try {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			WebDriver driver = new ChromeDriver(); // ChromeDriverの作成
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
			
			driver.quit(); // ブラウザを閉じる。
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
