package cn.tedu.ssm.exception;
/**
 * 用户名或者密码错误
 * @author Administrator
 *
 */
public class UserOrPwdMistake extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserOrPwdMistake() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserOrPwdMistake(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserOrPwdMistake(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserOrPwdMistake(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserOrPwdMistake(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
