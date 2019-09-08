package novel.spider.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * 小说的全部内容实体 
 * @author Administrator
 *
 */
public class Novel implements Serializable {

	private static final long serialVersionUID = -2906256303373673741L;
	/**
	 * 书名
	 */
	private String name;
	/**
	 * 小说的作者
	 */
	private String author;
	/**
	 * 小说的链接
	 */
	private String url;
	/**
	 * 小说类型
	 */
	private String type;
	/**
	 * 最后一章信息
	 */
	private String lastUpdateChapaterName;
	private String lastUpdateChapaterUrl;
	/**
	 * 小说最后更新时间
	 */
	private Date LastUpdateTime;
	/**
	 * 小说的状态
	 */
	private int status;
	/**
	 * 小说首字母
	 */
	private char shou;
	/**
	 * 小说平台的id
	 */
	private int platFromId;
	/**
	 * 这本小说存储到数据库的时间
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
