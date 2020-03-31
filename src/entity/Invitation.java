package entity;
/**
 * 帖子表
 * @author 黄龙
 * @@创建时间 2020年3月31日下午4:02:56
 */

import java.util.Date;

public class Invitation {
    private int id;
    private String title;
    private String summary;
    private String author; 
    private Date createdate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
    
}
