package cn.tedu.ssm.exception;
/**
 * 插入数据失败异常
 * @author Administrator
 *
 */
public class InsertExcetion extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertExcetion() {
		super();
	
	}

	public InsertExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public InsertExcetion(String message, Throwable cause) {
		super(message, cause);
		
	}

	public InsertExcetion(String message) {
		super(message);
	
	}

	public InsertExcetion(Throwable cause) {
		super(cause);
	
	}
	
	
	
}
