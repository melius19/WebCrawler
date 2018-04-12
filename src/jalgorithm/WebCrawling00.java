package jalgorithm;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebCrawling00 {
	public static void main(String[] args) throws Exception {
		// https://jsoup.org/
		String url = "http://en.wikipedia.org/";
		Document doc = Jsoup.connect(url).get();
		// System.out.println(doc);
		// System.out.println(doc.title());
		// Elements newsHeadlines = doc.select("#mp-itn b a");
		// for (Element headline : newsHeadlines) {
		// System.out.printf("%s\n\t%s\n\n", headline.attr("title"),
		// headline.absUrl("href"));
		// }

		// www.saramin.co.kr
		String domain = "http://www.saramin.co.kr";
		String searchword = "java";
		int page = 1;
		url = domain + "/zf_user/search/recruit/page/" + page + "?searchword=" + searchword
				+ "&searchType=search&order=relation";
		doc = Jsoup.connect(url).get();
		System.out.println(doc.title());
		Elements recruitNum = doc.select("div.title_search_area .numcase");
		System.out.println("recruitNum: " + recruitNum.get(0).text());

		Elements recruits = doc.select("ul.company_inbox .riin");
		// for (Element recruit : recruits) {
		// System.out.println("cname : " +
		// recruit.getElementsByTag("a").get(0).attr("title"));
		// System.out.println("title : " +
		// recruit.getElementsByTag("a").get(1).attr("title"));
		// System.out.println("href : " + domain +
		// recruit.getElementsByTag("a").get(0).attr("href"));
		// System.out.println();
		// // System.out.println("recruit0: " + recruit);
		// }

		// www.jobkorea.co.kr
		// domain = "http://www.jobkorea.co.kr";
		// url = domain + "/Search/?stext=" + searchword;
		// doc = Jsoup.connect(url).get();
		// System.out.println();
		// System.out.println(doc.title());
		// recruitNum = doc.select("#smGiList .devTotalCount");
		// System.out.println("recruitNum: " + recruitNum.get(0).text());
		//
		// recruits = doc.select("#smGiList ul.detailList li");
		// System.out.println(recruits);
		// for (Element recruit : recruits) {
		// System.out.println("cname : " + recruit.getElementsByTag("a").get(0).text());
		// System.out.println("href : " + domain +
		// recruit.getElementsByTag("a").get(0).attr("href"));
		// System.out.println("title : " + recruit.getElementsByTag("a").get(1).text());
		// System.out.println("href : " + domain +
		// recruit.getElementsByTag("a").get(1).attr("href"));
		// System.out.println();
		// }

		// www.incruit.com
		// url = "http://search.incruit.com/list/search.asp?col=job&il=y&kw=" +
		// searchword + "&startno=0";
		// doc = Jsoup.connect(url).get();
		// System.out.println();
		// System.out.println(doc.title());
		// recruitNum = doc.select(".numall");
		// System.out.println("recruitNum: " + recruitNum.get(0).text());

		// recruits = doc.select("ul.litype01 li");
		// System.out.println(recruits);
		// for (Element recruit : recruits) {
		// System.out.println("cname : " + recruit.getElementsByTag("a").get(0).text());
		// System.out.println("href : " +
		// recruit.getElementsByTag("a").get(0).attr("href"));
		// System.out.println("title : " + recruit.getElementsByTag("a").get(1).text());
		// System.out.println("href : " +
		// recruit.getElementsByTag("a").get(1).attr("href"));
		// System.out.println();
		// System.out.println();
		// }

		System.setProperty("webdriver.chrome.driver", "d:\\r_project\\chromedriver_win32\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.saramin.co.kr/zf_user/search/recruit?searchword=java&searchType=search&go=");
		WebElement content1 = driver.findElement(By.id("content")); // id로 Element 가져오기
		WebElement content2 = driver.findElementById("content");
		// List<WebElement> cheese = driver.findElements(By.className("cheese"));
		// //클래스이름으로 Element 가져오기
		// WebElement iframe = driver.findElement(By.tagName("iframe")); //태그이름으로
		// Element 가져오기
		System.out.println();
		System.out.println(content1);
		System.out.println();

		List<WebElement> webElementList = content2.findElements(By.cssSelector("ul.company_inbox .riin"));
		for (WebElement webElement : webElementList) {
			System.out.println();
			System.out.println("cname : " + webElement.findElements(By.tagName("a")).get(0).getAttribute("title"));
			System.out.println("title : " + webElement.findElements(By.tagName("a")).get(1).getAttribute("title"));
			System.out.println("href  : " + webElement.findElements(By.tagName("a")).get(0).getAttribute("href"));
		}
	}
}
