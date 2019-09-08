package novel.spider.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import novel.spider.NovelSiteEnum;

public class NovelSpiderUtils {

	private static final Map<NovelSiteEnum, Map<String, String>> CONTEXT_MAP = new HashMap<>();

	static {
		init();
	}

	private NovelSpiderUtils() {
	}

	private static void init() {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("conf/Spider-Rule.xml"));
			Element root = doc.getRootElement();
			List<Element> sites = root.elements("site");
			for (Element site : sites) {
				List<Element> li = site.elements();
				Map<String, String> subMap = new HashMap<>();
				for (Element l : li) {
					String name = l.getName();
					String text = l.getTextTrim();
					subMap.put(name, text);
				}
				CONTEXT_MAP.put(NovelSiteEnum.getEnumByUrl(subMap.get("url")), subMap);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拿到对应网站的解析规则
	 * 
	 * @param novelSiteEnum
	 * @return
	 */
	public static Map<String, String> getContext(NovelSiteEnum novelSiteEnum) {
		return CONTEXT_MAP.get(novelSiteEnum);
	}

	/**
	 * 合并规则:按照文件名排序
	 * 
	 * @param path
	 *            基础目录，该目录下面所有文本文件合并到targetFile文件中
	 * @param targeFile
	 *            被合并的文件，这个参数是null。合并到path/targe.txt
	 */
	public static void multiFileMerge(String path, String targeFile,boolean deleteThisFile) {
		targeFile = targeFile == null ? path + "/targe.txt" : targeFile;
		File[] files = new File(path).listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		Arrays.sort(files, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				int o1Index = Integer.parseInt(o1.getName().split("\\-")[0]);
				int o2Index = Integer.parseInt(o2.getName().split("\\-")[0]);
				if (o1Index > o2Index) {
					return 1;
				} else if (o1Index == o2Index){
					return 0;
				} else {
					return -1;
				}
			}
		});
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(targeFile), "UTF-8");
			for (File file : files) {
				BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));	
				String line = null;
				while ((line = bufr.readLine()) != null) {
					out.println(line);
				}
				bufr.close();
				if (deleteThisFile) {
					file.delete();
				}
			}
		} catch (Exception e1) {
			throw new RuntimeException(e1);
		} finally {
			out.close();
		}
	}

}
