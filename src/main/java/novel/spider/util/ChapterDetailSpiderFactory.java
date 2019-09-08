package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.DefaultChapterDetailSpider;
import novel.spider.interfaces.IChapterDetailSpider;

/**
 * ͨ��ָ����url�õ���ʵ����IChapterDetailSpider�ľ���ʵ����
 * 
 * @date 2019��4��25��
 * @author China_Sh
 *
 */
public final class ChapterDetailSpiderFactory {

	private ChapterDetailSpiderFactory() {

	}

	public static IChapterDetailSpider getChapterDetailSpider(String url) {
		IChapterDetailSpider spider = null;
		NovelSiteEnum noveSiteEnum = NovelSiteEnum.getEnumByUrl(url);
		switch (noveSiteEnum) {
		case SHIQIK:
		case ZhuiShuShenQi:
		case BiJiGe:
		case ZHULANG:
			spider = new DefaultChapterDetailSpider();
			break;
		default:
			break;
		}
		return spider;
	}

}