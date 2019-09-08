package novel.spider.impl;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import novel.spider.NovelSiteEnum;
import novel.spider.configuration.Configuration;
import novel.spider.entitys.Chapter;
import novel.spider.entitys.ChapterDetail;
import novel.spider.interfaces.IChapterDetailSpider;
import novel.spider.interfaces.IChapterSpider;
import novel.spider.interfaces.INovelDownload;
import novel.spider.util.ChapterDetailSpiderFactory;
import novel.spider.util.ChapterSpiderFactory;
import novel.spider.util.NovelSpiderUtils;

/**
 * 实现小说的下载：下载到txt文本文件中
 * 
 * @date 2019年4月25日
 * @author China_Sh
 *
 */
@SuppressWarnings("unused")
public class NovelDonwload implements INovelDownload {

	@Override
	public String download(String url, Configuration config) {
		IChapterSpider spider = ChapterSpiderFactory.getChapterSpider(url);
		List<Chapter> chapters = spider.getsCharacter(url);
		// 某个线程下载完毕之后，你得告诉主线程，我下载好了
		// 所有的程序下载好了，合并!!
		int size = config.getSize();
		// 2010章 100章一个线程
		// 需要21个线程
		int maxThreadSize = (int) Math.ceil(chapters.size() * 1.0 / size);
		Map<String, List<Chapter>> downloadTask = new HashMap<>();
		for (int i = 0; i < maxThreadSize; i++) {
			int fromindex = i * config.getSize();
			if (i == maxThreadSize - 1) {
				int toindex = chapters.size() - 1;
			}
			int toindex = i == maxThreadSize - 1 ? chapters.size() : i * config.getSize() + config.getSize();
			downloadTask.put(fromindex + "-" + toindex, chapters.subList(fromindex, toindex));

		}
		ExecutorService service = Executors.newFixedThreadPool(maxThreadSize);
		Set<String> keySet = downloadTask.keySet();
		List<Future<String>> tasks = new ArrayList<>();
		String savePath = config.getPath() + "/" + NovelSiteEnum.getEnumByUrl(url).getUrl();
		new File(savePath).mkdirs();
		for (String key : keySet) {
			tasks.add(service.submit(
					new DownloadCallbale(savePath + "/" + key + ".txt", downloadTask.get(key), config.getTryTimes())));
		}
		service.shutdown();
		for (Future<String> future : tasks) {
			try {
				System.out.println(future.get() + ",下载完成");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		NovelSpiderUtils.multiFileMerge(savePath, null,false);
		return savePath+"/target.txt";
	}

	class DownloadCallbale implements Callable<String> {

		private List<Chapter> chapters;
		private String path;
		private int tryTimes;

		public DownloadCallbale(String path, List<Chapter> chapters, int tryTimes) {
			this.chapters = chapters;
			this.path = path;
			this.tryTimes = tryTimes;
		}

		@Override
		public String call() throws Exception {
			try (PrintWriter out = new PrintWriter(path, "UTF-8");) {
				for (Chapter chapter : chapters) {
					IChapterDetailSpider ichapterDetail = ChapterDetailSpiderFactory
							.getChapterDetailSpider(chapter.getUrl());
					ChapterDetail detail = null;
					for (int i = 0; i < tryTimes; i++) {
						try {
							detail = ichapterDetail.getChapterDetail(chapter.getUrl());
							out.println(detail.getTitle());
							out.println(detail.getContent());
							break;
						} catch (RuntimeException e) {
							System.err.println("抓取错误"+(i+1)+"/"+tryTimes+"次");
						}
					}
				}
			} catch (Exception e) {
				throw new RuntimeException();
			}
			return path;
		}

	}

}
