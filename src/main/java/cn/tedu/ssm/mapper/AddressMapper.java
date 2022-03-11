package cn.tedu.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.ssm.entity.Address;

/**
 * 收货地址持久层
 * @author Administrator
 *
 */
@Repository
public interface AddressMapper {
	
	
	/**
	 * 修改收货地址
	 * @param address 用户修改的收货地址
	 * @return 受影响的行数
	 */
	  Integer  updateAddress(Address address);
	
	
	/**
	 * 新增收货地址信息
	 * @param address 用户提交的收货地址信息
	 * @return 返回1添加成功
	 */
	  Integer  addNewAddress(Address address);
	 
	 /**
	  * 设置为默认
	  * @param aid 指定aid地址
	  * @param is_dfull 默认
	  * @return 返回受影响的行数
	  */
	 Integer updateByAid(@Param("aid") Integer aid,
			 			@Param("is_dfull")Integer is_dfull);
	 
	 /**
	  * 设置为不默认
	  * @param aid 不等于aid地址
	  * @param is_dfull 不默认
	  * @return 返回受影响的行数
	  */
	 Integer updateAtAid(@Param("aid") Integer aid,
	 		        	@Param("is_dfull")Integer is_dfull);
	 
	 /**
	  * 删除指定aid
	  * @param aid 指定id
	  * @return 返回受影响的行数
	  */
	 Integer deleteAddress(@Param("aid") Integer aid );
	 
		/**
		 * 查询所有的收货地址信息
		 * @return 返回所有收货地址信息
		 */
		 List<Address> findAddrress(Integer uid);
}
