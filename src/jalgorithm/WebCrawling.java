package jalgorithm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawling {
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
		for (Element recruit : recruits) {
			System.out.println("cname :  " + recruit.getElementsByTag("a").get(0).attr("title"));
			System.out.println("title :  " + recruit.getElementsByTag("a").get(1).attr("title"));
			System.out.println("href  :  " + domain + recruit.getElementsByTag("a").get(0).attr("href"));
			System.out.println();
			// System.out.println("recruit0: " + recruit);
		}

		// www.jobkorea.co.kr
		domain = "http://www.jobkorea.co.kr";
		url = domain + "/Search/?stext=" + searchword;
		doc = Jsoup.connect(url).get();
		System.out.println();
		System.out.println(doc.title());
		recruitNum = doc.select("#smGiList .devTotalCount");
		System.out.println("recruitNum: " + recruitNum.get(0).text());

		recruits = doc.select("#smGiList ul.detailList li");
		// System.out.println(recruits);
		for (Element recruit : recruits) {
			System.out.println("cname :  " + recruit.getElementsByTag("a").get(0).text());
			System.out.println("href  :  " + domain + recruit.getElementsByTag("a").get(0).attr("href"));
			System.out.println("title :  " + recruit.getElementsByTag("a").get(1).text());
			System.out.println("href  :  " + domain + recruit.getElementsByTag("a").get(1).attr("href"));
			System.out.println();
		}

		// www.incruit.com
		url = "http://search.incruit.com/list/search.asp?col=job&il=y&kw=" + searchword + "&startno=0";
		doc = Jsoup.connect(url).get();
		System.out.println();
		System.out.println(doc.title());
		recruitNum = doc.select(".numall");
		System.out.println("recruitNum: " + recruitNum.get(0).text());

		recruits = doc.select("ul.litype01 li");
		// System.out.println(recruits);
		for (Element recruit : recruits) {
			System.out.println("cname :  " + recruit.getElementsByTag("a").get(0).text());
			System.out.println("href  :  " + recruit.getElementsByTag("a").get(0).attr("href"));
			System.out.println("title :  " + recruit.getElementsByTag("a").get(1).text());
			System.out.println("href  :  " + recruit.getElementsByTag("a").get(1).attr("href"));
			System.out.println();
			System.out.println();
		}
	}
}
