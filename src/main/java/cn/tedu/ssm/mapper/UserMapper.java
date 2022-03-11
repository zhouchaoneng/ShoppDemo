package cn.tedu.ssm.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.ssm.entity.User;

/**
 * 持久层接口
 * @author Administrator
 *
 */
@Repository
public interface UserMapper {
	
	/**
	 * 添加新的用户信息
	 * @param user 用户信息
	 * @return 返回1添加成功
	 */
	Integer  addNewUser(User user);
	
	/**
	 * 修改密码操作
	 * @param user 用户提交的参数
	 * @return 返回1修改成功
	 */
	Integer  updatePwd(@Param("uid") Integer uid,
					   @Param("password")String password);
	
	/**
	 * 修改个人资料
	 * @param user 用户需要修改的数据
	 * @return 返回1修改成功
	 */
	Integer updateUserMessage(User user);
	/**
	 * 上传头像
	 * @param uid
	 *  @param avatar
	 * @return 返回1修改成功
	 */
	Integer updataUpload(@Param("uid") Integer uid,
			 			@Param("avatar")String avatar);
	
	/**
	 * 查询用户名是否存在
	 * @param name 用户名
	 * @return 返回查询结果
	 */
	User findByName(String name);
	
	/**
	 * 查询用户名和密码,isDelete为0
	 * @param username 用户登录参数
	 * @param password 密码登录参数
	 * @return uid不等于null就可以登录
	 */
	User findByNameAndPwd(@Param("username") String username,
							 @Param("password") String password);
	/**
	 * 根据uid查询用户名
	 * @param uid 用户id
	 * @return 返回用户名
	 */
	String findByUid(Integer uid);
	
	
}
