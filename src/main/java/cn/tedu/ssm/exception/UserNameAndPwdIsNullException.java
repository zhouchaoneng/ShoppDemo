package cn.tedu.ssm.exception;
/**
 * 用户名和密码参数为空
 * @author Administrator
 *
 */
public class UserNameAndPwdIsNullException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAndPwdIsNullException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNameAndPwdIsNullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNameAndPwdIsNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameAndPwdIsNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNameAndPwdIsNullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
