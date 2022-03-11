package cn.tedu.ssm.business;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ssm.entity.User;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.OldPwdEqualNewPwdException;
import cn.tedu.ssm.exception.OriginalPwdmistakeException;
import cn.tedu.ssm.exception.ParamNullException;
import cn.tedu.ssm.exception.PngFormartNotException;
import cn.tedu.ssm.exception.PwdInconformityException;
import cn.tedu.ssm.exception.UpdateException;
import cn.tedu.ssm.exception.UserExistExcetion;
import cn.tedu.ssm.exception.UserNameAndPwdIsNullException;
import cn.tedu.ssm.exception.UserNotFoundException;
import cn.tedu.ssm.exception.UserOrPwdMistake;
import cn.tedu.ssm.util.JsonResult;

/**
 * 业务层接口
 * @author Administrator
 *
 */

@Service
public interface IUserSerivce {
	
	/**
	 * 
	 * 用户注册业务
	 * @param 接收客户端发送的数据
	 * @param confirmPwd 接收确认密码
	 * @throws InsertExcetion 插入数据失败异常
	 * @throws UserExistExcetion 用户名已存在异常
	 * @throws PwdInconformityException 二次输入的密码不一致
	 * @throws UserNameAndPwdIsNullException 用户名密码为空
	 */
	 void regUser(User user,String confirmPwd)throws InsertExcetion,UserExistExcetion,PwdInconformityException,UserNameAndPwdIsNullException;
	 
	 /**
	  * 用户登录业务
	  * @param username 用户名
	  * @param password 密码
	  * @param	auto  不为空就自动登录
	  * @throws UserNameAndPwdIsNullException 用户名密码不能为空
	  * @throws UserNotFoundException 用户不存在
	  * @throws UserOrPwdMistake 账号或密码错误
	  */
	 void loginUser(String username,String password,String auto,HttpServletRequest request)throws UserNameAndPwdIsNullException,UserNotFoundException,UserOrPwdMistake;
	 
	 /**
	  * 修改密码
	  * @param uid 修改此id的密码
	  * @param password 原始密码
	  * @param confirmPwd 确认密码
	  * @param newPwd 新密码
	  * @throws PwdInconformityException 二次输入的密码不一致
	  * @throws OldPwdEqualNewPwdException	修改的密码不能和旧密码一致
	  * @throws OriginalPwdmistakeException	原始密码错误
	  * @throws ParamNullException	不能提交空数据
	  * @throws	UpdateException 修改失败请检查!
	  */
	 void updatePwd(Integer uid,String password,String confirmPwd,String newPwd)
			 throws PwdInconformityException,OldPwdEqualNewPwdException,
			 OriginalPwdmistakeException,ParamNullException,
			 UpdateException;
	 
	 /**
	  * 回填个人资料信息
	  * @return 返回需要回填的数据
	  */
	 User userMessage(Integer uid);
	 
	 /**
	  * 修改个人资料
	  * @param email 邮箱号
	  * @param pthone 手机号
	  * @param isDelete 0为女1为男
	  * @throws ParamNullException 非空验证
	  * @throws UpdateException 修改失败
	  */
	 void updateUserMessage(Integer uid,String email,Integer pthone,Integer gender) throws ParamNullException,UpdateException;
	 
	 /**
	  * 上传头像
	  * @param uid 指定uid用户的头像修改
	  * @param avatar 头像路径
	  * @throws UpdateException 修改失败!
	  * @throws PngFormartNotException 上传的头像不是png格式
	  */
	 String updateUpload(Integer uid,String avatar,HttpServletRequest request,MultipartFile file)throws UpdateException,PngFormartNotException,IllegalStateException, IOException;
}
