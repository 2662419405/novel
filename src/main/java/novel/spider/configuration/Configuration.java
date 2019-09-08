package novel.spider.configuration;

import java.io.Serializable;

public class Configuration implements Serializable {

	private static final long serialVersionUID = 9127091783485829441L;
	/**
	 * 默认下载的数量
	 */
	public static final int DEFAUT_SIZE = 100;
	/**
	 * 每个线程下载每一章所允许的最大尝试次数
	 */
	public static final int DEFAUT_TRYTIMES = 5;
	/**
	 * 下载后的文件的基地址
	 */
	private String path;
	/**
	 * 某个线程下载的最大章节数量
	 */
	private int size;
	private int tryTimes;

	public Configuration() {
		this.size = DEFAUT_SIZE;
		this.tryTimes=DEFAUT_TRYTIMES;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTryTimes() {
		return tryTimes;
	}

	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}
	
}
