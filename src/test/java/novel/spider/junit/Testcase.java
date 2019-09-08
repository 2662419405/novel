package novel.spider.junit;

import java.util.List;
import org.junit.Test;

import novel.spider.NovelSiteEnum;
import novel.spider.configuration.Configuration;
import novel.spider.entitys.Chapter;
import novel.spider.impl.DefaultChapterDetailSpider;
import novel.spider.impl.DefaultChapterSpider;
import novel.spider.impl.NovelDonwload;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.util.NovelSpiderUtils;

public class Testcase {
	/**
	 * 用于某个网站的所有章节列表
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		IChapterSpider spider = new DefaultChapterSpider();
		try {
			SslUtils.ignoreSsl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Chapter> chapters = spider.getsCharacter("http://www.xiaoshuozu.com/shu/1534/");
		for (Chapter chap : chapters) {
			System.out.println(chap);
		}
	}

	/**
	 * 用于测试具体的章节类
	 */
	@Test
	public void testGetSiteContent() {
		System.out.println(
				NovelSpiderUtils.getContext(NovelSiteEnum.getEnumByUrl("http://www.xiaoshuozu.com/shu/1534/9568323.html")));
	}

	/**
	 * 用于测试具体的章节细节实体类
	 */
	@Test
	public void testGetChapterDetail() {
		IChapterDetailSpider spider = new DefaultChapterDetailSpider();
		System.out.println(spider.getChapterDetail("http://www.xiaoshuozu.com/shu/1534/9568323.html").getContent());
	}

	/**
	 * 用于测试下载小说
	 */
	@Test
	public void downloadtest() {
		NovelDonwload download = new NovelDonwload();
		Configuration config = new Configuration();
		config.setPath("D:/BaiduNetdiskDownload/China_SH");
		config.setSize(50);
		System.out.println(
				"文件已经下载好了，保存在:" + download.download("http://www.xs222.cc/html/0/87/", config) + "赶紧去看看吧!");
	}

	/**
	 * 合并文件
	 */
	@Test
	public void TestHebing() {
		NovelSpiderUtils.multiFileMerge("D:/BaiduNetdiskDownload/China_SH", null, false);
	}
}
