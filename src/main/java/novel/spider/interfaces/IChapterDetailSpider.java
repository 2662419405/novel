package novel.spider.interfaces;

import novel.spider.entitys.ChapterDetail;

public interface IChapterDetailSpider {
	/**
	 * ����һ��url���Ҿ͸���һ����Ӧ��վ���½�ʵ��
	 * @param url
	 * @return
	 */
	public ChapterDetail getChapterDetail(String url);
}
	