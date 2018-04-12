package jalgorithm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCrawling02 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "d:\\r_project\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// www.jobkorea.co.kr
		String url = "http://www.jobkorea.co.kr";
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 1000L);
		WebElement srchText = driver.findElement(By.id("stext"));
		WebElement srchBtn = driver.findElementById("common_search_btn");

		srchText.sendKeys("C++");
		srchText.sendKeys(Keys.RETURN);
		// srchBtn.click();

		WebElement recruitNumWebEl = driver.findElement(By.cssSelector("#smGiList .devTotalCount"));
		int recruitNum = Integer.parseInt(recruitNumWebEl.getText().replaceAll(",", ""));
		System.out.println("recruitNum: " + recruitNum);

		int totalPageNum = recruitNum / 30;
		int recrnum = 0;

		for (int pg = 1; pg < 11; pg++) {
			List<WebElement> recruits = driver.findElements(By.cssSelector("#smGiList ul.detailList li"));
			System.out.println(recruits);
			for (WebElement recruit : recruits) {
				List<WebElement> recruitEl = recruit.findElements(By.tagName("a"));
				System.out.println(++recrnum + ". " + recruitEl.get(0).getText() + ", " + recruitEl.get(1).getText());
				System.out.println("url : " + recruitEl.get(1).getAttribute("href"));
				System.out.println();
			}
			List<WebElement> pages = driver.findElements(By.cssSelector("#smGiList div.tplPagination ul li"));
			WebElement toPage = null;
			for (WebElement page : pages) {
				// System.out.println("Page : " + page.getText());
				if (((pg + 1) + "").equals(page.getText()))
					toPage = page;
			}
			if (toPage != null) {
				toPage.click();
				wait.until(ExpectedConditions.textToBe(By.cssSelector("#smGiList li span.now"), (pg + 1) + ""));
			}
			// https://sites.google.com/a/chromium.org/chromedriver/downloads
			// https://nesoy.github.io/articles/2017-03/Selenium
			// https://seleniumhq.github.io/selenium/docs/api/java/overview-summary.html
		}
	}
}
