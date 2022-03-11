package cn.tedu.ssm.business.impl.user_serivce;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.CDATASection;

import cn.tedu.ssm.business.IShoppSerivce;
import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.exception.UpdateException;
import cn.tedu.ssm.mapper.AddressMapper;
import cn.tedu.ssm.mapper.ShoppingMapper;

/**
 * 商品业务层实现类
 * @author Administrator
 *
 */
@Service
public class ShopSerivceImpl implements IShoppSerivce {
	private ClassPathXmlApplicationContext cs;

	private ShoppingMapper mapper;

	
	//回填商品
	@Override
	public List<Shoppnging> showShop() {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("shoppingMapper", ShoppingMapper.class);
		List<Shoppnging> shop =	mapper.findShop();
		return shop;
	}
	//加入功能
	@Override
	public void addCollectShop(Integer id,Integer uid) throws UpdateException {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("shoppingMapper", ShoppingMapper.class);
	Integer count =	mapper.addCollect(id,0,uid);
	if(count<1) {
		throw new UpdateException("加入失败,请检查!");
	}
	
	
		
	}
	@Test
	public void test() {

	
	
	}
	
	//显示收藏商品
	@Override
	public List<Shoppnging> showCollectShop(Integer uid) {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("shoppingMapper", ShoppingMapper.class);
		return  mapper.showCollectShop(0,uid);
	}
	//取消收藏
	public void deleteCollectShop(Integer id,Integer uid) throws UpdateException {
	cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
	mapper = cs.getBean("shoppingMapper", ShoppingMapper.class);
	Integer count =	mapper.addCollect(id,1,uid);
	if(count<1) {
		throw new UpdateException("取消失败!,请检查!");
	}
		
	}
	//显示商品订单信息
	@SuppressWarnings("unchecked")
	@Override
	public List<Shoppnging> findByidShop(Integer[] id) {
		cs = new ClassPathXmlApplicationContext("Spring-dao.xml");
		mapper = cs.getBean("shoppingMapper", ShoppingMapper.class);
		List<Shoppnging> listShop =	mapper.findByidShop(id);
		return listShop;
	
		
	
	}
}
