package cn.tedu.ssm.util;

/**
 * 返回自定义json格式
 * 
 * @author Administrator
 *
 */
public class JsonResult<T> {

	private String message;
	// 返回的信息
	private Integer staet;
	// 返回的
	private T date;
	// 封装需要返回的数据

	public JsonResult() {

	}
	
	public JsonResult(Integer staet) {
		this.staet = staet;
	}
	
	public JsonResult(String message,Integer staet) {
		this.staet = staet;
		this.message = message;
	}
	
	public JsonResult(T date,Integer staet) {
		this.staet = staet;
		this.date = date;
	}
	
	public JsonResult(String message,Integer staet,T date) {
		this.staet = staet;
		this.message = message;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "JsonResult [message=" + message + ", staet=" + staet + ", date=" + date + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStaet() {
		return staet;
	}

	public void setStaet(Integer staet) {
		this.staet = staet;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

}
