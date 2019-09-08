package novel.spider.configuration;

import java.io.Serializable;

public class Configuration implements Serializable {

	private static final long serialVersionUID = 9127091783485829441L;
	/**
	 * Ĭ�����ص�����
	 */
	public static final int DEFAUT_SIZE = 100;
	/**
	 * ÿ���߳�����ÿһ�������������Դ���
	 */
	public static final int DEFAUT_TRYTIMES = 5;
	/**
	 * ���غ���ļ��Ļ���ַ
	 */
	private String path;
	/**
	 * ĳ���߳����ص�����½�����
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
