package cn.tedu.ssm.mapper;
/**
 * 商品持久层
 * @author Administrator
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.ssm.entity.Shoppnging;
@Repository
public interface ShoppingMapper {
	
	
	/**
	 * 回填商品
	 * @return
	 */
	List<Shoppnging> findShop();
	
	/**
	 * 加入收藏
	 * @param id 指定id
	 * @return 返回受影响的行数
	 */
	Integer  addCollect(@Param("id") Integer id,
						@Param("status") Integer status,
						@Param("uid") Integer uid);
	
	/**
	 * 回填收藏商品
	 * @return 加入收藏商品
	 */
	List<Shoppnging> showCollectShop(@Param("status") Integer status,
									 @Param("uid") Integer uid);
	
	
	/**
	 * 回填订单页面商品信息
	 * @param id 指定商品id
	 * @return 返回商品信息
	 */
	List<Shoppnging>  findByidShop(Integer[] id);
	
}
