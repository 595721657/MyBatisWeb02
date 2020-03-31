package entity;
/**
 * 回复表
 * @author 黄龙
 * @@创建时间 2020年3月31日下午4:04:43
 */

import java.util.Date;

public class Reply {
   private int id;
   private int invid;
   private String content;
   private String author;
   private Date createdate;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getInvid() {
	return invid;
}
public void setInvid(int invid) {
	this.invid = invid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
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
