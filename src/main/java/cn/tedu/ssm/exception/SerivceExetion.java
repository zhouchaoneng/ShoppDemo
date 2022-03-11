package cn.tedu.ssm.exception;
/**
 * 业务层异常
 * @author Administrator
 *
 */
public class SerivceExetion extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SerivceExetion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SerivceExetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SerivceExetion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SerivceExetion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SerivceExetion(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
