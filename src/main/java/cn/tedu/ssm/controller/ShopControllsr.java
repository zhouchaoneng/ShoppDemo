package cn.tedu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ssm.business.impl.user_serivce.AdressSerivceImpl;
import cn.tedu.ssm.business.impl.user_serivce.ShopSerivceImpl;
import cn.tedu.ssm.entity.Address;
import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.util.JsonResult;

/**
 * 商品控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("shops")
public class ShopControllsr extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 	回填收藏数据
	@RequestMapping("showShop.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<List<Shoppnging>> showShop(HttpServletRequest request) {
		return new JsonResult<List<Shoppnging>>(new ShopSerivceImpl().showCollectShop(getUid(request)), SUCCESS);
	}
	
	
	// 	加入收藏
	@RequestMapping("addCollect.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> findShop(Integer id,HttpServletRequest request) {
		new ShopSerivceImpl().addCollectShop(id,getUid(request));
		return new JsonResult (SUCCESS) ;
	}
	
	// 	取消收藏
	@RequestMapping("deleteCollect.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> deleteCollect(Integer id,HttpServletRequest request) {
		new ShopSerivceImpl().deleteCollectShop(id,getUid(request));
		return new JsonResult (SUCCESS) ;
	}
	
	
	// 	回填商品信息
	@RequestMapping("findShop.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<List<Shoppnging>> findShop() {
	List<Shoppnging> shoping =	new ShopSerivceImpl().showShop();
		return new JsonResult<List<Shoppnging>>(shoping, SUCCESS) ;
	}
}
