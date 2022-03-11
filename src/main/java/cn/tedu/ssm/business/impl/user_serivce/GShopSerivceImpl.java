package cn.tedu.ssm.business.impl.user_serivce;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import cn.tedu.ssm.business.GShopSerivce;
import cn.tedu.ssm.entity.Address;
import cn.tedu.ssm.entity.GShop;
import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.exception.DeleteException;
import cn.tedu.ssm.exception.InsertExcetion;
import cn.tedu.ssm.exception.ParamNullException;
import cn.tedu.ssm.mapper.AddressMapper;
import cn.tedu.ssm.mapper.GshopMapper;
import cn.tedu.ssm.mapper.ShoppingMapper;

/**
 * 购物车业务层实现类
 * @author Administrator
 *
 */

@Service
public class GShopSerivceImpl implements GShopSerivce{
	
	private ClassPathXmlApplicationContext cs;

	private GshopMapper mapper;

	@Override
	public void addGShop(Integer gid,Integer uid) throws InsertExcetion,ParamNullException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("gshopMapper", GshopMapper.class);
	   Integer count =	mapper.findAid(gid,uid);
	if(count!=null) {
		throw new ParamNullException("商品已存在!");
	}
	 count	 = mapper.addGShop(gid, uid);
	 if(count<1) {
		 throw new InsertExcetion("添加失败!");
	 }
			
	}


	@Override
	public List<Shoppnging> showGshop(Integer uid) {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("gshopMapper", GshopMapper.class);
		return mapper.showGshop(uid);
	}

	//删除
	@Override
	public void deleteGshop(Integer gid) throws DeleteException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("gshopMapper", GshopMapper.class);
	Integer count =	mapper.deleteGshop(gid);
	if(count!=1) {
		throw new DeleteException("删除失败!");
	}

	}
	
	//批量删除
	@Override
	public void deletesShop(Integer[] gid) throws DeleteException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("gshopMapper", GshopMapper.class);
		Integer count =	mapper.deletesShop(gid);
		if(count<=1) {
			throw new DeleteException("删除失败!");
		}
	}
	
	
}
