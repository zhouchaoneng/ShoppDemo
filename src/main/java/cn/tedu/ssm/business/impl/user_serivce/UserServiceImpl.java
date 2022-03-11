package cn.tedu.ssm.business.impl.user_serivce;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ssm.business.IUserSerivce;
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
import cn.tedu.ssm.mapper.UserMapper;
import cn.tedu.ssm.util.JsonResult;

/**
 * 业务层实现类
 * 
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements IUserSerivce {

	private ClassPathXmlApplicationContext cs;

	private UserMapper mapper;
	// 持久层接口

	
	//上传头像
	@Override
	public String updateUpload(Integer uid, String avatar,HttpServletRequest request,MultipartFile file) throws UpdateException, PngFormartNotException, IllegalStateException, IOException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		String lastText = avatar.substring(avatar.lastIndexOf(".")+1);
		List<String> formart = getPngFormart();
		if(!(formart.contains(lastText))) {
			throw new PngFormartNotException("上传的头像格式不支持");
		}
		String pngUrl = request.getServletContext().getRealPath("png");
		//获取保存在webapp下的png的位置
		pngUrl = pngUrl.replaceAll("\\\\", "\\/");
		//修改\为/
	
		String pngName = generateStr(5)+".png";
		//图片名
		File dest = new File(pngUrl,pngName);
		//保存图片的文件的位置,第二个是图片的名字
		file.transferTo(dest);
		System.err.println("执行成功!"+pngUrl+pngName);
		String avatarUrl = "/png/"+pngName;
		Integer count =	mapper.updataUpload(uid, avatarUrl);
		if(count!=1) {
			throw new UpdateException("上传失败,请检查!");
		}
		return avatarUrl;
	}
	
	
	@Override
	public User userMessage(Integer uid) {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		// 根据登录用户id查询用户名
		String username = mapper.findByUid(uid);
		// 根据用户名查询回填数据
		User user = mapper.findByName(username);
		return user;
	}
	
	//修改用户信息
	@Override
	public void updateUserMessage(Integer uid, String email, Integer pthone, Integer gender)
			throws ParamNullException, UpdateException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		if (email == null || ("".equals(email)) || pthone == null || gender == null) {
			throw new ParamNullException("表单不能为空！");
		}
		User user = new User(uid, null, null, null, gender, pthone, null, null, email);
		Integer count = mapper.updateUserMessage(user);
		// 受影响的行数为0修改失败
		if (count != 1) {
			throw new UpdateException("修改失败,请检查!");
		}
	}
	
	//修改密码
	@Override
	public void updatePwd(Integer uid, String password, String confirmPwd, String newPwd)
			throws PwdInconformityException, OldPwdEqualNewPwdException, OriginalPwdmistakeException,
			ParamNullException, UpdateException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		// 非空验证
		if (uid == null || password == null || ("".equals(password)) || confirmPwd == null || ("".equals(confirmPwd))
				|| newPwd == null || ("".equals(newPwd))) {
			throw new ParamNullException("提交的数据不能为空！");
		}
		// 根据uid查询用户名
		String username = mapper.findByUid(uid);
		// 根据用户名把需要的数据查询出来
		User user = mapper.findByName(username);
		// 获取用户提交的原始密码
		String clientPwd = generateMD5(user.getSaltValue(), password);
		// 判断原始密码是否正确
		if (!(clientPwd.equals(user.getPassword()))) {
			throw new OriginalPwdmistakeException("原始密码错误!");
		}
		// 二次输入的密码不一致
		if (!(confirmPwd.equals(newPwd))) {
			throw new PwdInconformityException("新密码,确认密码不一致");
		}
		// 获取新密码
		String clientNewPwd = generateMD5(user.getSaltValue(), newPwd);
		// 判断新密码是否和修改之前密码一致
		if (clientNewPwd.equals(clientPwd)) {
			throw new OldPwdEqualNewPwdException("新密码不能和原始密码一致");
		}
		// 受影响的行数为0修改失败
		Integer count = mapper.updatePwd(uid, clientNewPwd);
		if (count != 1) {
			throw new UpdateException("修改失败,请检查!");
		}
	}
	
	//登录功能
	public void loginUser(String username, String password, String auto, HttpServletRequest request)
			throws UserNameAndPwdIsNullException, UserNotFoundException, UserOrPwdMistake {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		// 参数非空验证

		if (username == null || "".equals(username) || password == null || "".equals(password)) {
			throw new UserNameAndPwdIsNullException("用户名或者密码提交为空!");
		}
		User user = mapper.findByName(username);
		if (user == null) {
			throw new UserNotFoundException("用户不存在!");
		}
		String passwords = generateMD5(user.getSaltValue(), password);
		User message = mapper.findByNameAndPwd(username, passwords);
		if (message == null) {
			throw new UserOrPwdMistake("账号或密码错误!");
		}
		if ("true".equals(auto)) {
			// 自动登录 true保存用户信息
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("uid", user.getUid());
			// 当自动登录不勾起就保存session数据
		}
	}
	
	//注册功能
	public void regUser(User user, String confirmPwd)
			throws InsertExcetion, UserExistExcetion, PwdInconformityException, UserNameAndPwdIsNullException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("userMapper", UserMapper.class);
		// 参数非空验证
		if (user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			throw new UserNameAndPwdIsNullException("用户名或者密码提交为空!");
		}
		User name = mapper.findByName(user.getUsername());
		if (name != null) {
			throw new UserExistExcetion("用户名已存在!");
		}
		if (!user.getPassword().equals(confirmPwd)) {

			throw new PwdInconformityException("二次输入的密码不一致!");
		}

		String salt = generateStr(5);
		// 随机盐值,参数为长度
		user.setSaltValue(salt);
		// 盐值
		String md5 = generateMD5(salt, user.getPassword());
		// md5加密
		user.setPassword(md5);
		// TOOD 密码
		user.setIsDelete(0);
		user.setGender(1);
		user.setPthone(132567);
		user.setEmail("@105733");
		user.setAvatar("../images/index/user.jpg");
		user.setCreator(user.getUsername());
		// 创建人
		user.setEstablishTime(new Date());
		// 创建时间
		user.setLastAmendTime(new Date());
		// 最后创建时间
		user.setLastModifier(user.getUsername());
		// 最后创建人
		System.out.println(mapper);
		Integer count = mapper.addNewUser(user);
		if (count != 1) {
			throw new InsertExcetion("注册失败,请检查!");
		}
	}

	/**
	 * 密码加密储存
	 * 
	 * @param salt     盐值
	 * @param password 用户输入的密码
	 * @return 返回md5加密后的结果
	 */
	private String generateMD5(String salt, String password) {
		try {
			String md5 = DigestUtils.md5DigestAsHex((salt + password).getBytes());
			// 摘要运算
			return md5;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 返回随机长度字符为盐值
	 * 
	 * @param length 盐值长度
	 * @return 返回盐值
	 */
	private String generateStr(int length) {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char a = (char) Math.round(Math.random() * 25 + 97);
			builder.append(a);
		}
		return builder.toString().trim();
	}
	
	/**
	 * 获取的图片格式
	 * @return 图片格式
	 */
	private List<String> getPngFormart(){
		List<String> foramrt = new ArrayList<String>();
		InputStream ist = null;
		try {
			Properties properties = new Properties();
			// 读取jdbc配置文件对象
			ist =UserServiceImpl.class.getClassLoader().getResourceAsStream("db.properties");
			properties.load(ist);
			String pngText = properties.getProperty("pngText");
			String[] date = pngText.split("-");
			for (int i = 0; i < date.length; i++) {
				foramrt.add(date[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ist.close();
			} catch (Exception e2) {
			e2.printStackTrace();
			}
		}
	return foramrt;	
	}
	
}
