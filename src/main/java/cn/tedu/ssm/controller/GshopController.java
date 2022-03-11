package cn.tedu.ssm.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ssm.business.impl.user_serivce.GShopSerivceImpl;
import cn.tedu.ssm.business.impl.user_serivce.ShopSerivceImpl;
import cn.tedu.ssm.entity.Shoppnging;
import cn.tedu.ssm.util.JsonResult;

/**
 * 购物车控制器层
 * @author Administrator
 *
 */
@Controller
@RequestMapping("Gshop")
public class GshopController extends BaseController {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//显示购物车
	@RequestMapping("showGShop.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<List<Shoppnging>> showGShop(HttpServletRequest request){
	List<Shoppnging> shoppngings =	new GShopSerivceImpl().showGshop(getUid(request));
		return new JsonResult<List<Shoppnging>>(shoppngings, SUCCESS);
	}
	
	//加入购物车功能
	@RequestMapping("addGshop.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> addGshop(Integer gid,HttpServletRequest request){
		new GShopSerivceImpl().addGShop(gid, getUid(request));
		return new JsonResult<>(SUCCESS);
	}
	
	//删除商品
	@RequestMapping("deleteShop.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> deleteShop(Integer gid){
		new GShopSerivceImpl().deleteGshop(gid);
		return new JsonResult<>(SUCCESS);
	}
	
		//批量删除商品
		@RequestMapping("arrShop.do")
		@ResponseBody // 返回json需要添加的注解
		public JsonResult<Void> deleteArrShop(Integer[] arr){
			new GShopSerivceImpl().deletesShop(arr);
			return new JsonResult<>(SUCCESS);
		}
		
		//显示订单信息
		@RequestMapping("overShop.do")
		@ResponseBody // 返回json需要添加的注解
		public JsonResult<List<Shoppnging>> overShop(Integer[] gid){
			List<Shoppnging> list =	new ShopSerivceImpl().findByidShop(gid);
			return new JsonResult<List<Shoppnging>>(list, SUCCESS);
		}
}
