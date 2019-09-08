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
	 * ����ĳ����վ�������½��б�
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
	 * ���ڲ��Ծ�����½���
	 */
	@Test
	public void testGetSiteContent() {
		System.out.println(
				NovelSpiderUtils.getContext(NovelSiteEnum.getEnumByUrl("http://www.xiaoshuozu.com/shu/1534/9568323.html")));
	}

	/**
	 * ���ڲ��Ծ�����½�ϸ��ʵ����
	 */
	@Test
	public void testGetChapterDetail() {
		IChapterDetailSpider spider = new DefaultChapterDetailSpider();
		System.out.println(spider.getChapterDetail("http://www.xiaoshuozu.com/shu/1534/9568323.html").getContent());
	}

	/**
	 * ���ڲ�������С˵
	 */
	@Test
	public void downloadtest() {
		NovelDonwload download = new NovelDonwload();
		Configuration config = new Configuration();
		config.setPath("D:/BaiduNetdiskDownload/China_SH");
		config.setSize(50);
		System.out.println(
				"�ļ��Ѿ����غ��ˣ�������:" + download.download("http://www.xs222.cc/html/0/87/", config) + "�Ͻ�ȥ������!");
	}

	/**
	 * �ϲ��ļ�
	 */
	@Test
	public void TestHebing() {
		NovelSpiderUtils.multiFileMerge("D:/BaiduNetdiskDownload/China_SH", null, false);
	}
}
