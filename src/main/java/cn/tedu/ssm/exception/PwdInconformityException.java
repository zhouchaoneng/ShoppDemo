package cn.tedu.ssm.exception;
/**
 * 二次输入密码不一致错误
 * @author Administrator
 *
 */
public class PwdInconformityException extends SerivceExetion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PwdInconformityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PwdInconformityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PwdInconformityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PwdInconformityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PwdInconformityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
