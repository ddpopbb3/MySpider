package com.spider.demo.lyp.LinkTypeData;

public class LinkTypeData {
	/** 唯一标识 */
	private int id;
	/** 链接 */
	private String href;
	/** 标题 */
	private String text;
	/** 摘要 */
	private String summary;
	/** 内容 */
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "LinkTypeData [id=" + id + ", href=" + href + ", text=" + text + ", summary=" + summary + ", content=" + content + "]";
	}

}
