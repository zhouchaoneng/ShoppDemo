package cn.tedu.ssm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * @author Administrator
 *
 */
@Component
@Aspect //切面类
public class TimeElapsedAspect {
	
	
	/**
	 * 计算登录时间
	 * @throws Throwable 
	 * 	@Around 代表执行的范围
	 */	
	//添加pjp参数 	//.*.*代表执行 该包下的所有类,所有方法(..)代表所有参数方法
	@Around("execution(* cn.tedu.ssm.controller.*.*(..))")
	public Object Proceed(ProceedingJoinPoint pjp) throws Throwable {
	System.out.println("!执行了");
		//开始时间
	long start =	System.currentTimeMillis();
	//获取当前毫秒值
	Object object = pjp.proceed();
	//执行该方法
	//记录结束时间
	//开始时间
	long ends =	System.currentTimeMillis();
	//获取当前毫秒值
	System.out.println("耗时:"+(ends-start)+"ms");
	return object;
	}
}
