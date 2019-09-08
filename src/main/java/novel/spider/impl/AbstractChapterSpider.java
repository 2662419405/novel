package novel.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import novel.spider.NovelSiteEnum;
import novel.spider.entitys.Chapter;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderUtils;

/**
 * 抓取任意网站的章节列表
 * @author Administrator
 *
 */
public abstract class AbstractChapterSpider extends AbstractSpider implements IChapterSpider {

	@Override
	public List<Chapter> getsCharacter(String url) {
		try {
			String result = crawl(url);
			Document doc =  Jsoup.parse(result);
			doc.setBaseUri(url);
			Elements as = doc.select(NovelSpiderUtils.getContext(NovelSiteEnum.getEnumByUrl(url)).get("chapter-list-selector"));
			List<Chapter> chap = new ArrayList<>();
			for (Element a : as) {
				Chapter c = new Chapter();
				c.setTitle(a.text());
				c.setUrl(a.absUrl("href"));
				chap.add(c);
			}
			return chap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
