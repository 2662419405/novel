package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Chapter;

public interface IChapterSpider {
	/**
	 * 给一个完整的url地址，就给你返回一个所有的章节列表
	 * @param url
	 * @return
	 */
	public List<Chapter> getsCharacter(String url);
	
	
}
