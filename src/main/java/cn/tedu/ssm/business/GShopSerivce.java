package cn.tedu.ssm.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.ssm.entity.GShop;
import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.exception.DeleteException;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.ParamNullException;

/**
 * 购物车业务层
 * @author Administrator
 *
 */

@Service
public interface GShopSerivce {
	
	
	/**
	 * 删除指定id的商品
	 * @param gid id
	 * @return 返回1删除成功 
	 * @throws DeleteException 删除失败
	 */
	void deleteGshop(Integer gid)throws DeleteException;
	
	/**
	 * 批量删除指定id的商品
	 * @param gid id
	 * @return 返回受影响的行数
	 * @throws DeleteException 删除失败
	 */
	void deletesShop(Integer[] gid)throws DeleteException;
	
	/**
	 * 添加购物车
	 * @param gid 商品id
	 * @param uid 用户id
	 * @throws InsertExcetion 添加失败
	 * @throws ParamNullException 商品id不能重复
	 */
	void addGShop(Integer gid,Integer uid)throws InsertExcetion,ParamNullException;
	
	/**
	 * 显示购物车商品
	 * @return 返回商品数据
	 */
	List<Shoppnging> showGshop(Integer uid);
}
