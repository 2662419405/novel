package novel.spider.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * С˵��ȫ������ʵ�� 
 * @author Administrator
 *
 */
public class Novel implements Serializable {

	private static final long serialVersionUID = -2906256303373673741L;
	/**
	 * ����
	 */
	private String name;
	/**
	 * С˵������
	 */
	private String author;
	/**
	 * С˵������
	 */
	private String url;
	/**
	 * С˵����
	 */
	private String type;
	/**
	 * ���һ����Ϣ
	 */
	private String lastUpdateChapaterName;
	private String lastUpdateChapaterUrl;
	/**
	 * С˵������ʱ��
	 */
	private Date LastUpdateTime;
	/**
	 * С˵��״̬
	 */
	private int status;
	/**
	 * С˵����ĸ
	 */
	private char shou;
	/**
	 * С˵ƽ̨��id
	 */
	private int platFromId;
	/**
	 * �ⱾС˵�洢�����ݿ��ʱ��
	 */
	private Date addTime;

	public Novel() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLastUpdateChapaterName() {
		return lastUpdateChapaterName;
	}

	public void setLastUpdateChapaterName(String lastUpdateChapaterName) {
		this.lastUpdateChapaterName = lastUpdateChapaterName;
	}

	public String getLastUpdateChapaterUrl() {
		return lastUpdateChapaterUrl;
	}

	public void setLastUpdateChapaterUrl(String lastUpdateChapaterUrl) {
		this.lastUpdateChapaterUrl = lastUpdateChapaterUrl;
	}

	public Date getLastUpdateTime() {
		return LastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		LastUpdateTime = lastUpdateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public char getShou() {
		return shou;
	}

	public void setShou(char shou) {
		this.shou = shou;
	}

	public int getPlatFromId() {
		return platFromId;
	}

	public void setPlatFromId(int platFromId) {
		this.platFromId = platFromId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
