package cn.tedu.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import cn.tedu.ssm.business.IUserSerivce;
import cn.tedu.ssm.business.impl.user_serivce.UserServiceImpl;
import cn.tedu.ssm.entity.User;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.PwdInconformityException;
import cn.tedu.ssm.exception.SerivceExetion;
import cn.tedu.ssm.exception.UserExistExcetion;
import cn.tedu.ssm.exception.UserNameAndPwdIsNullException;
import cn.tedu.ssm.util.JsonResult;

/**
 * 用户控制器层
 * 
 * @author Administrator
 *
 */

@Controller
@RequestMapping("users")
public class UserController extends BaseController {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	// 修改密码
	@RequestMapping("upPwd.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> UpdatePwd(@RequestParam("password") String password,
			@RequestParam("confirmPwd") String confirmPwd, @RequestParam("newPwd") String newPwd,HttpServletRequest request) {
		new UserServiceImpl().updatePwd(getUid(request), password, confirmPwd, newPwd);
		return new JsonResult<>(SUCCESS);
	}
	
	/**
	 * 接收头像上传,只能使用post请求上传
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping(value="uload.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<String> addUload(@RequestParam("file") MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException {
		String avatar = file.getOriginalFilename();
		String fileUrl = new UserServiceImpl().updateUpload
		(getUid(request),avatar,request,file);
		//头像路径
		JsonResult<String>	js	=new JsonResult<>();
		js.setDate(fileUrl);
		js.setStaet(SUCCESS);
		return js;
	}
	
	// 回填表单数据
	@RequestMapping("userMessage.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<User> userMessage(HttpServletRequest request) {
		Integer uid = getUid(request);
		User user = new UserServiceImpl().userMessage(uid);
		return new JsonResult<User>("表单回填", SUCCESS, user);
	}

	// 修改个人资料
	@RequestMapping("upMessage.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> upMessage(@RequestParam("email") String email, @RequestParam("pthone") Integer pthone,
			@RequestParam("gender") String gender,
			HttpServletRequest request) {
		Integer uid = getUid(request);
		Integer genders = -1;
		if (gender.equals("男")) {
			genders = 1;
		} else {
			genders = 0;
		}
		new UserServiceImpl().updateUserMessage(uid,email, pthone, genders);
		return new JsonResult<>(SUCCESS);
	}

	// 注册功能
	@RequestMapping("reg.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> regUser(User user, String confirmPwd) {
		new UserServiceImpl().regUser(user, confirmPwd);
		return new JsonResult<>(SUCCESS);
	}

	// 登录功能
	@RequestMapping("login.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("auto") String auto, HttpServletRequest request) {
		new UserServiceImpl().loginUser(username, password, auto, request);
		return new JsonResult<>(SUCCESS) ;
	}

	/**
	 * 访问登录界面
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("logHtml.do")
	public String logHtml(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("username");
		String pwd = (String) session.getAttribute("password");
		Integer uid = (Integer) session.getAttribute("uid");
		if (name != null && pwd != null && uid !=null) {
			return "redirect:/TeduStore/web/index.html";
		} else {
			return "redirect:/TeduStore/login.html";
		}
	}
	
	
}
