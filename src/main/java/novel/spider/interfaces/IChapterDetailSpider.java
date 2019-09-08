package novel.spider.interfaces;

import novel.spider.entitys.ChapterDetail;

public interface IChapterDetailSpider {
	/**
	 * 给我一个url，我就给你一个对应网站的章节实体
	 * @param url
	 * @return
	 */
	public ChapterDetail getChapterDetail(String url);
}
	