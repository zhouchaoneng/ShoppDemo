package cn.tedu.ssm.exception;
/**
 * 原始密码和新密码一致
 * @author Administrator
 *
 */
public class OldPwdEqualNewPwdException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OldPwdEqualNewPwdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OldPwdEqualNewPwdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public OldPwdEqualNewPwdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public OldPwdEqualNewPwdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OldPwdEqualNewPwdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
