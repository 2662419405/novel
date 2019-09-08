package novel.spider;

/**
 * 已经被支持的小说网站枚举
 * 
 * @author Administrator
 *
 */
public enum NovelSiteEnum {
	BiJiGe(1, "bimige.cc"), ZhuiShuShenQi(2, "zhuishushenqi.com"), SHIQIK(3, "17k.com"), ZHULANG(4,
			"zhulang.com"), BXWX(5, "bxwx9.org"), WENXUE(6, "23wenxue.com"), KANSHUZHONG(7,
					"kanshuzhong.com"), DINGDIAN(8,
							"dingdiann.com"), XIAOSHUOZU(9, "xiaoshuozu.com"), XINDINGDIAN(10, "xs222.cc");
	private int id;
	private String url;

	private NovelSiteEnum(int id, String url) {
		this.id = id;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static NovelSiteEnum getEnumById(int id) {
		switch (id) {
		case 1:
			return BiJiGe;
		case 2:
			return ZhuiShuShenQi;
		default:
			throw new RuntimeException("id=" + id + "是目前不被支持的小说网站");
		}
	}

	public static NovelSiteEnum getEnumByUrl(String url) {
		for (NovelSiteEnum novelSiteEnum : values()) {
			if (url.contains(novelSiteEnum.url)) {
				return novelSiteEnum;
			}
		}
		throw new RuntimeException("url=" + url + "是目前不被支持的小说网站");
	}
}
