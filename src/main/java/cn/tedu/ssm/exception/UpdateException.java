package cn.tedu.ssm.exception;
/**
 * 修改失败!
 * @author Administrator
 *
 */
public class UpdateException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UpdateException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
