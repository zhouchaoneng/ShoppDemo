package cn.tedu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 购物车持久层
 * @author Administrator
 *
 */

import cn.tedu.ssm.entity.Shoppnging;
@Repository
public interface GshopMapper {
	
	
	/**
	 * 删除指定的gid商品
	 * @param gid 指定商品id
	 * @return 返回1删除成功
	 */
	Integer deleteGshop(Integer gid);
	
	/**
	 * 批量删除指定的gid商品
	 * @param gid 指定商品id
	 * @return 返回受影响的行数
	 */
	Integer deletesShop(Integer[] gid);
	
	/**
	 * 添加购物车
	 * @param gShop 参数
	 * @return 返回1添加成功
	 */
	Integer addGShop(@Param("gid") Integer gid,
					 @Param("uid") Integer uid);
	
	/**
	 * 显示购物车数据
	 * @param uid 指定用户的购物车数据
	 * @return 返回商品数据
	 */
	List<Shoppnging> showGshop(Integer uid);
	
	/**
	 * 判断商品是否重复
	 * @param aid
	 * @return 返回小于0就添加失败
	 */
	 Integer findAid(@Param("gid") Integer aid,
			 		@Param("uid") Integer uid);
}	
