package jalgorithm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCrawling01 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "d:\\r_project\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// www.jobkorea.co.kr
		String url = "http://www.jobkorea.co.kr";
		driver.get(url);
		WebElement srchText = driver.findElement(By.id("stext"));
		WebElement srchBtn = driver.findElementById("common_search_btn");

		srchText.sendKeys("C++");
		srchText.sendKeys(Keys.RETURN);
		// srchBtn.click();

		WebElement recruitNum = driver.findElement(By.cssSelector("#smGiList .devTotalCount"));
		System.out.println("recruitNum: " + Integer.parseInt(recruitNum.getText().replaceAll(",", "")));

		List<WebElement> recruits = driver.findElements(By.cssSelector("#smGiList ul.detailList li"));
		System.out.println(recruits);
		int recrnum = 0;
		for (WebElement recruit : recruits) {
			List<WebElement> recruitEl = recruit.findElements(By.tagName("a"));
			System.out.println(++recrnum + " cname : " + recruitEl.get(0).getText());
			System.out.println("href : " + recruitEl.get(0).getAttribute("href"));
			System.out.println("title : " + recruitEl.get(1).getText());
			System.out.println("title : " + recruitEl.get(1).getAttribute("href"));
			System.out.println();
		}
		List<WebElement> pages = driver.findElements(By.cssSelector("#smGiList div.tplPagination ul li"));
		WebElement toPage = null;
		for (WebElement page : pages) {
			// System.out.println("Page : " + page.getText());
			if ("2".equals(page.getText()))
				toPage = page;
		}
		toPage.click();
		WebDriverWait wait = new WebDriverWait(driver, 1000L);
		// Thread.sleep(20L);
		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#smGiList
		wait.until(ExpectedConditions.textToBe(By.cssSelector("#smGiList li span.now"), "2"));

		recruits = driver.findElements(By.cssSelector("#smGiList ul.detailList li"));
		// recruit.getAttribute("innerHTML");

		for (WebElement recruit : recruits) {
			// System.out.println(recruit.getAttribute("innerHTML"));
			List<WebElement> recruitEl = recruit.findElements(By.tagName("a"));
			System.out.println(++recrnum + " cname : " + recruitEl.get(0).getText());
			System.out.println("href : " + recruitEl.get(0).getAttribute("href"));
			System.out.println("title : " + recruitEl.get(1).getText());
			System.out.println("title : " + recruitEl.get(1).getAttribute("href"));
			System.out.println();
		}
	}
}
