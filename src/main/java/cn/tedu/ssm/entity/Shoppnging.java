package cn.tedu.ssm.entity;

import java.util.Objects;

/**
 * 商品实体类
 * @author Administrator
 *
 */
public class Shoppnging extends ParentEitity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private long	category_id;//分类id
	private String	item_type; //商品系列
	private String	title; //标题
	private String	sell_point;//卖点
	private double   price;
	private Integer num;//数量
	private String  barcode;//条形码
	private String	image;//图片
	private Integer	status;//商品状态  0:收藏   1：不收藏   ',
	private Integer uid;//'显示优先级',

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoppnging other = (Shoppnging) obj;
		return Objects.equals(id, other.id);
	}
	public Shoppnging(String id, long category_id, String item_type, String title, String sell_point, double price,
			Integer num, String barcode, String image, Integer status, Integer uid) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.item_type = item_type;
		this.title = title;
		this.sell_point = sell_point;
		this.price = price;
		this.num = num;
		this.barcode = barcode;
		this.image = image;
		this.status = status;
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Shoppnging [id=" + id + ", category_id=" + category_id + ", item_type=" + item_type + ", title=" + title
				+ ", sell_point=" + sell_point + ", price=" + price + ", num=" + num + ", barcode=" + barcode
				+ ", image=" + image + ", status=" + status + ", uid=" + uid + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSell_point() {
		return sell_point;
	}
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPriority() {
		return uid;
	}
	public void setPriority(Integer uid) {
		this.uid = uid;
	}
	
	
	
	
}
