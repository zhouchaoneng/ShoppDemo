package cn.tedu.ssm.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.exception.UpdateException;

/**
 * 
 * @author Administrator
 *
 */

@Service
public interface IShoppSerivce {
	
	/**
	 * 显示所有商品数据
	 * @return 所有商品数据
	 */
	List<Shoppnging> showShop();
	
	/**
	 * 加入收藏功能
	 * @throws UpdateException 修改失败!
	 */
	void  addCollectShop(Integer id,Integer uid)throws UpdateException;
	
	/**
	 * 回填收藏数据
	 * @param status 0为收藏
	 * @return 返回商品数据
	 */
	List<Shoppnging> showCollectShop(Integer uid); 
	
	/**
	 * 取消收藏功能
	 * @param id 指定商品id
	 * @throws UpdateException  修改失败
	 */
	void deleteCollectShop(Integer id,Integer uid)throws UpdateException;
	
	/**
	 * 回填订单信息
	 * @param id 指定的id商品
	 * @return 返回指定id商品信息
	 */
	List<Shoppnging> findByidShop(Integer[] id);
}
