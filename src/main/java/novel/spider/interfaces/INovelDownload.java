package novel.spider.interfaces;

import novel.spider.configuration.Configuration;

public interface INovelDownload {

	/**
	 * ͨ��һ��url�����ı����ݣ����ص��ı��ļ�����
	 * url��ָ���½��б��
	 * @param url
	 * @return
	 */
	public String download(String url,Configuration config);
	
}
