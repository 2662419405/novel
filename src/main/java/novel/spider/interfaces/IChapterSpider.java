package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Chapter;

public interface IChapterSpider {
	/**
	 * ��һ��������url��ַ���͸��㷵��һ�����е��½��б�
	 * @param url
	 * @return
	 */
	public List<Chapter> getsCharacter(String url);
	
	
}
