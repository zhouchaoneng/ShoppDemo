package cn.tedu.ssm.business.impl.user_serivce;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ssm.business.IAddressSerivce;
import cn.tedu.ssm.entity.Address;
import cn.tedu.ssm.exception.DeleteException;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.ParamNullException;
import cn.tedu.ssm.exception.UpdateException;
import cn.tedu.ssm.mapper.AddressMapper;
import cn.tedu.ssm.mapper.UserMapper;

/**
 * 业务层实现类
 * 
 * @author Administrator
 *
 */
@Service
public class AdressSerivceImpl implements IAddressSerivce {
	private ClassPathXmlApplicationContext cs;

	private AddressMapper mapper;

	// 回填地址信息
	public List<Address> findAdress(Integer uid) {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("addressMapper", AddressMapper.class);
		List<Address> list = mapper.findAddrress(uid);
		return list;
	}


	@Override
	public void insertAddress(Address address) throws InsertExcetion, ParamNullException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("addressMapper", AddressMapper.class);
		if (address.getUid() == null) {
			throw new ParamNullException("用户id不能为空!");
		}
		// 不默认
		address.setIs_dfull(1);
		// 创建人
		address.setEstablishTime(new Date());
		// 创建时间
		address.setLastAmendTime(new Date());
		// 最后创建时间
		Integer count = mapper.addNewAddress(address);
		if (count != 1) {
			throw new InsertExcetion("添加收货地址失败,请检查!");
		}
	}

	// 设为默认功能
	@Transactional
	public void updateByAid(Integer aid) throws UpdateException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("addressMapper", AddressMapper.class);
		Integer count = mapper.updateByAid(aid, 0);
		if (count < 1) {
			throw new UpdateException("设置失败1");
		}
		count = mapper.updateAtAid(aid, 1);
		if (count < 1) {
			throw new UpdateException("设置失败2");
		}
	}

	// 删除功能
	@Override
	public void deleteByAid(Integer aid) throws DeleteException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("addressMapper", AddressMapper.class);
		Integer count = mapper.deleteAddress(aid);
		if (count < 1) {
			throw new DeleteException("删除失败,请检查!");
		}
	}

	@Override
	public void updateAddress(Address address) throws UpdateException, ParamNullException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("addressMapper", AddressMapper.class);
		if(address.getProvince()==null || "".equals(address.getProvince()) || 
				address.getCity()==null || "".equals(address.getCity()) ||
				  address.getArea()==null || "".equals(address.getArea()) ||
						  address.getAddres()==null || "".equals(address.getAddres())) {
			throw new ParamNullException("省市区,详细地址不能为空!");
		}
		
	Integer count =	mapper.updateAddress(address);
	if(count<1) {
		throw new UpdateException("修改失败,请检查");
	}
		
	}

}
