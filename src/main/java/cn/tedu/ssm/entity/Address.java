package cn.tedu.ssm.entity;

/**
 * 地址实体类
 * @author Administrator
 *
 */

import java.util.Date;
import java.util.Objects;

public class Address extends ParentEitity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer aid;
	private Integer uid;
	private String aName;// 收货人信息
	private String province;
	private Integer province_code; // 省
	private String city;
	private Integer city_code; // 市
	private String area;
	private Integer area_code; // 区
	private Integer zip; // 邮编
	private String addres; // 详细地址
	private Integer phone; // 电话
	private Integer g_phone; // 固定电话
	private String teg; // 地址标签
	private Integer is_dfull; // 0为默认,1为不默认
	
	
	
	public Integer getG_phone() {
		return g_phone;
	}

	public void setG_phone(Integer g_phone) {
		this.g_phone = g_phone;
	}

	
	
	
	
	public Address(Integer aid, Integer uid, String aName, String province, Integer province_code, String city,
			Integer city_code, String area, Integer area_code, Integer zip, String addres, Integer phone,
			Integer g_phone, String teg, Integer is_dfull) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.aName = aName;
		this.province = province;
		this.province_code = province_code;
		this.city = city;
		this.city_code = city_code;
		this.area = area;
		this.area_code = area_code;
		this.zip = zip;
		this.addres = addres;
		this.phone = phone;
		this.g_phone = g_phone;
		this.teg = teg;
		this.is_dfull = is_dfull;
	}

	public Address() {
		
	}
	
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", uid=" + uid + ", aName=" + aName + ", province=" + province
				+ ", province_code=" + province_code + ", city=" + city + ", city_code=" + city_code + ", area=" + area
				+ ", area_code=" + area_code + ", zip=" + zip + ", addres=" + addres + ", phone=" + phone + ", g_phone="
				+ g_phone + ", teg=" + teg + ", is_dfull=" + is_dfull + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(aid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(aid, other.aid);
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getProvince_code() {
		return province_code;
	}
	public void setProvince_code(Integer province_code) {
		this.province_code = province_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getCity_code() {
		return city_code;
	}
	public void setCity_code(Integer city_code) {
		this.city_code = city_code;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getArea_code() {
		return area_code;
	}
	public void setArea_code(Integer area_code) {
		this.area_code = area_code;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getTeg() {
		return teg;
	}
	public void setTeg(String teg) {
		this.teg = teg;
	}
	public Integer getIs_dfull() {
		return is_dfull;
	}
	public void setIs_dfull(Integer is_dfull) {
		this.is_dfull = is_dfull;
	}
	
	
}
