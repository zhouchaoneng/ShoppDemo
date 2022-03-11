package cn.tedu.ssm.exception;

/**
 * 上传的头像,只支持png格式图片
 * @author Administrator
 *
 */
public class PngFormartNotException extends SerivceExetion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PngFormartNotException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PngFormartNotException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PngFormartNotException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PngFormartNotException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PngFormartNotException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
