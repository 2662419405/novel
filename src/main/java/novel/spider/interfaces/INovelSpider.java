package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Novel;

/**
 * 爬取某个站点的小说列表
 * 
 * @author Administrator
 *
 */
public interface INovelSpider {
	/**
	 * 给一个url，我就给你一堆小说实体
	 * @param url
	 * @return
	 */
	public List<Novel> getNovels(String url);
}
