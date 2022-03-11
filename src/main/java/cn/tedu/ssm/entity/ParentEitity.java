package cn.tedu.ssm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 父类实体类
 * 
 * @author Administrator
 *
 */
abstract class ParentEitity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String creator;
	// 创建人
	private Date establishTime;
	// 创建时间
	private String lastModifier;
	// 最后创建人
	private Date lastAmendTime;
	// 最后创建时间

	public ParentEitity() {

	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getEstablishTime() {
		return establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}

	public String getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(String lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Date getLastAmendTime() {
		return lastAmendTime;
	}

	public void setLastAmendTime(Date lastAmendTime) {
		this.lastAmendTime = lastAmendTime;
	}

}
