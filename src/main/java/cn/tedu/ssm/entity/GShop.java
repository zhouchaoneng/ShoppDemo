package cn.tedu.ssm.entity;

import java.util.Objects;

/**
 * 购物车实体类
 * @author Administrator
 *
 */
public class GShop extends ParentEitity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  Integer sid;
	private  Integer uid;
	private  Integer gid;
	@Override
	public int hashCode() {
		return Objects.hash(sid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GShop other = (GShop) obj;
		return Objects.equals(sid, other.sid);
	}
	public GShop(Integer sid, Integer uid, Integer gid) {
		super();
		this.sid = sid;
		this.uid = uid;
		this.gid = gid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}

}
