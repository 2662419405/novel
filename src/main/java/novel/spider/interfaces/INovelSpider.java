package novel.spider.interfaces;

import java.util.List;

import novel.spider.entitys.Novel;

/**
 * ��ȡĳ��վ���С˵�б�
 * 
 * @author Administrator
 *
 */
public interface INovelSpider {
	/**
	 * ��һ��url���Ҿ͸���һ��С˵ʵ��
	 * @param url
	 * @return
	 */
	public List<Novel> getNovels(String url);
}
