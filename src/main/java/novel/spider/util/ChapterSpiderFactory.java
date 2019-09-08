package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.DefaultChapterSpider;
import novel.spider.interfaces.IChapterSpider;

public final class ChapterSpiderFactory {

	private ChapterSpiderFactory() {
	}

	/**
	 * ͨ��������url������һ��ʵ����IChapter�ӿڵ�ʵ����
	 * 
	 * @param url
	 * @return
	 */
	public static IChapterSpider getChapterSpider(String url) {
		NovelSiteEnum novelsiteEnum = NovelSiteEnum.getEnumByUrl(url);
		IChapterSpider chapspider = null;
		switch (novelsiteEnum) {
		case SHIQIK:
		case ZhuiShuShenQi:
		case BiJiGe:
		case ZHULANG:
		case BXWX:
		case WENXUE:
		case KANSHUZHONG:
		case DINGDIAN:
		case XIAOSHUOZU:
		case XINDINGDIAN:
			chapspider = new DefaultChapterSpider();
			break;
		default:
			throw new RuntimeException();
		}
		return chapspider;
	}

}
