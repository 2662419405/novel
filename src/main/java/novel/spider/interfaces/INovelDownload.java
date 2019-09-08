package novel.spider.interfaces;

import novel.spider.configuration.Configuration;

public interface INovelDownload {

	/**
	 * 通过一个url给出文本内容，下载到文本文件当中
	 * url是指定章节列表的
	 * @param url
	 * @return
	 */
	public String download(String url,Configuration config);
	
}
