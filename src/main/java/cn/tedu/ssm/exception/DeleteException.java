package cn.tedu.ssm.exception;

/**
 * 删除失败
 * @author Administrator
 *
 */
public class DeleteException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DeleteException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
