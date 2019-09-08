package novel.spider.util;

import java.net.URI;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;

public class NovelSpiderHttpGet extends HttpGet {

	public NovelSpiderHttpGet() {
		super();
	}

	public NovelSpiderHttpGet(String uri) {
		super(uri);
		setDefaultConfig();
	}

	public NovelSpiderHttpGet(URI uri) {
		super(uri);
	}

	/**
	 * 设置服务器的超时时间
	 */
	private void setDefaultConfig() {
		this.setConfig(RequestConfig.custom().setSocketTimeout(2_000).setConnectTimeout(10_000).setConnectionRequestTimeout(10_000).build());
		this.setHeader("User-Agent", "NovelSpider");
	}

}
