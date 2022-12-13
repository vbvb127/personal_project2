package item.vo;

public class ItemVO {
	private String item_no;
	private String title;
	private String content;
	private int item_price;
	private int item_cnt;
	
	public ItemVO() {
	}

	public String getItem_no() {
		return item_no;
	}

	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public int getItem_cnt() {
		return item_cnt;
	}

	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}

	@Override
	public String toString() {
		return "ItemVO [item_no=" + item_no + ", title=" + title + ", content=" + content + ", item_price=" + item_price
				+ ", item_cnt=" + item_cnt + ", getItem_no()=" + getItem_no() + ", getTitle()=" + getTitle()
				+ ", getContent()=" + getContent() + ", getItem_price()=" + getItem_price() + ", getItem_cnt()="
				+ getItem_cnt() + "]";
	}

	
	
}
