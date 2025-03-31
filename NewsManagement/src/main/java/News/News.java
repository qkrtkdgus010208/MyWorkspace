package News;

import java.sql.Blob;

public class News {
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
	public Blob getImg() {
		return img;
	}
	public void setImg(Blob img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/* 적절한 변수 선언 및 Getter, Setter 생성*/
	/* 단, date는 String으로 생성할 것 */
	private int id;
	private String title;
	private Blob img;
	private String date;
	private String content;
}