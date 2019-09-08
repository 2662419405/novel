package novel.spider.util;

import novel.spider.NovelSiteEnum;
import novel.spider.impl.DefaultChapterDetailSpider;
import novel.spider.interfaces.IChapterDetailSpider;

/**
 * 通过指定的url拿到了实现了IChapterDetailSpider的具体实现类
 * 
 * @date 2019年4月25日
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