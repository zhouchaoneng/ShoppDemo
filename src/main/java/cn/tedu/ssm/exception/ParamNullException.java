package cn.tedu.ssm.exception;

/**
 * 不能提交空数据
 * @author Administrator
 *
 */
public class ParamNullException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamNullException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParamNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ParamNullException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ParamNullException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParamNullException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
