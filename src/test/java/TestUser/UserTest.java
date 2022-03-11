package TestUser;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import cn.tedu.ssm.entity.User;
import cn.tedu.ssm.mapper.UserMapper;


public class UserTest {
	ClassPathXmlApplicationContext cs;

	@Before
	public void init() {
		cs = new ClassPathXmlApplicationContext("Spring-Redis.xml");
	}

	@Test
	public void testJedis() {
	
		RedisTemplate<String, Object> redisTemplate = cs.getBean("redisTemplate", RedisTemplate.class);
		redisTemplate.opsForValue().set("dome", "helloWorld");
		//使用set方法										1天以后过期

		String dome = (String) redisTemplate.opsForValue().get("dome");

		//使用get方法获取对象
		System.out.println(dome);

	}

	@After
	public void destory() {
		cs.close();
	}
}
