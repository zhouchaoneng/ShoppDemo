package cn.tedu.ssm.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tedu.ssm.entity.Address;
import cn.tedu.ssm.exception.DeleteException;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.ParamNullException;
import cn.tedu.ssm.exception.UpdateException;

/**
 * 收货地址业务层
 * @author Administrator
 *
 */
@Service
public interface IAddressSerivce {
	
	/**
	 * 修改收货地址
	 * @param address 修改的信息
	 * @throws UpdateException 修改失败
	 * @throws ParamNullException 省市区,详细地址不能为空
	 */
	void updateAddress(Address address)throws UpdateException,ParamNullException;
	
	/**
	 * 添加收货地址
	 * @param address 用户提交的收货地址
	 * @throws InsertExcetion 添加失败请检查
	 * @throws ParamNullException	参数不能为空
	 */
	void insertAddress(Address address)throws InsertExcetion,ParamNullException;
	
	/**
	 * 设置为默认功能
	 * @param aid 指定aid
	 * @throws UpdateException 修改失败
	 */
	void  updateByAid(Integer aid)throws UpdateException;
	
	/**
	 * 删除功能
	 * @param aid 指定id
	 * @throws DeleteException 删除失败,请检查!
	 */
	void  deleteByAid(Integer aid)throws DeleteException;
	
	

	/**
	 * 回填收货地址信息
	 * @return 返回收货地址信息
	 */
	List<Address> findAdress(Integer uid);
}
