package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {

		try {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			WebDriver driver = new ChromeDriver(); // ChromeDriver�̍쐬
			driver.get("http://www.google.com/xhtml"); // get()�Ńu���E�U�N��
			Thread.sleep(5000);
			// �u���E�U�̗v�f���w�� ���\�b�h�����킩��₷���ł���ˁB
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("ChromeDriver");
			searchBox.submit();
			// �������~(����m�F�̈�)
			Thread.sleep(5000);
			driver.quit(); // �u���E�U�����B
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
