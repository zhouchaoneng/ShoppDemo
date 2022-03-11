package cn.tedu.ssm.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 用户实体类
 * 
 * @author Administrator 实现序列化接口,告诉jvm这个类的对象可以被序列化
 */
public class User extends ParentEitity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String username;
	private String saltValue;
	// 盐值
	private String password;
	private Integer gender;
	// 性别 0为女,1为男
	private Integer pthone;
	private Integer isDelete;
	// 是否删除0为未删除,1为删除
	private String avatar;
	// 头像
	private String email;

	public User() {
	}

	public User(Integer uid, String username, String saltValue, String password, Integer gender, Integer pthone,
			Integer isDelete, String avatar, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.saltValue = saltValue;
		this.password = password;
		this.gender = gender;
		this.pthone = pthone;
		this.isDelete = isDelete;
		this.avatar = avatar;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", saltValue=" + saltValue + ", password=" + password
				+ ", gender=" + gender + ", pthone=" + pthone + ", isDelete=" + isDelete + ", avatar=" + avatar
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(uid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(uid, other.uid);
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSaltValue() {
		return saltValue;
	}

	public void setSaltValue(String salt_value) {
		this.saltValue = salt_value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getPthone() {
		return pthone;
	}

	public void setPthone(Integer pthone) {
		this.pthone = pthone;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
