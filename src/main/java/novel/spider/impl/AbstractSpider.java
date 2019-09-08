package novel.spider.impl;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import novel.spider.NovelSiteEnum;
import novel.spider.util.NovelSpiderHttpGet;
import novel.spider.util.NovelSpiderUtils;

public class AbstractSpider {
	/**
	 * 抓取指定小说网站的内容
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected String crawl(String url) throws Exception {
		// try width resource
		try (CloseableHttpClient httpclient = HttpClientBuilder.create().build();
				CloseableHttpResponse httpResponse = httpclient.execute(new NovelSpiderHttpGet(url));) {
			String result = EntityUtils.toString(httpResponse.getEntity(),
					NovelSpiderUtils.getContext(NovelSiteEnum.getEnumByUrl(url)).get("charset"));
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
