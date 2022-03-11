package cn.tedu.ssm.exception;
/**
 * 用户名已存在异常
 * @author Administrator
 *
 */
public class UserExistExcetion extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistExcetion() {
		super();
	
	}

	public UserExistExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserExistExcetion(String message, Throwable cause) {
		super(message, cause);
	
	}

	public UserExistExcetion(String message) {
		super(message);
	
	}

	public UserExistExcetion(Throwable cause) {
		super(cause);
	
	}

}
