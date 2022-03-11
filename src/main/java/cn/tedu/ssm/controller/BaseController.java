package cn.tedu.ssm.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ssm.exception.DeleteException;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.OldPwdEqualNewPwdException;
import cn.tedu.ssm.exception.OriginalPwdmistakeException;
import cn.tedu.ssm.exception.ParamNullException;
import cn.tedu.ssm.exception.PngFormartNotException;
import cn.tedu.ssm.exception.PwdInconformityException;
import cn.tedu.ssm.exception.SerivceExetion;
import cn.tedu.ssm.exception.UpdateException;
import cn.tedu.ssm.exception.UserExistExcetion;
import cn.tedu.ssm.exception.UserNameAndPwdIsNullException;
import cn.tedu.ssm.exception.UserNotFoundException;
import cn.tedu.ssm.exception.UserOrPwdMistake;
import cn.tedu.ssm.util.JsonResult;

/**
 * 处理控制器发生的异常
 * 只处理自定义异常
 * @author Administrator
 *
 */

@Controller
public  abstract  class BaseController implements Serializable{
	
	/**
	 * 成功值0
	 */
	public static final Integer SUCCESS = 0;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 处理的异常范围
	 * @param e 可以是Throwable下的任何异常
	 * @return 返回异常内容
	 */
	@ExceptionHandler(SerivceExetion.class)
	@ResponseBody //json返回数据必须添加的注解
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult js =new  JsonResult();
		js.setMessage(e.getMessage());
		if(e instanceof InsertExcetion) {
			js.setStaet(1);
		}else if(e instanceof PwdInconformityException){
			js.setStaet(2);
		}else if (e instanceof UserExistExcetion) {
			js.setStaet(3);
		}else if (e instanceof UserNameAndPwdIsNullException) {
			js.setStaet(4);
		}else if (e instanceof UserNotFoundException) {
			js.setStaet(5);
		}else if (e instanceof UserOrPwdMistake) {
			js.setStaet(6);
		}else if (e instanceof ParamNullException) {
			js.setStaet(7);
		}else if (e instanceof OriginalPwdmistakeException) {
			js.setStaet(8);
		}else if (e instanceof OldPwdEqualNewPwdException) {
			js.setStaet(9);
		}else if (e instanceof UpdateException) {
			js.setStaet(10);
		}else if (e instanceof PngFormartNotException) {
			js.setStaet(11);
		}else if (e instanceof DeleteException) {
			js.setStaet(12);
		}
		return js;
	}
	
	/**
	 * 获取session中的uid值
	 * @param request 
	 * @return 返回uid
	 */
	public Integer getUid(HttpServletRequest request) {
	HttpSession session =	request.getSession();
	Integer  uid =(Integer)  session.getAttribute("uid");
	return uid;
	}

}
