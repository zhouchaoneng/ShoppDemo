package cn.tedu.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ssm.business.impl.user_serivce.AdressSerivceImpl;
import cn.tedu.ssm.business.impl.user_serivce.UserServiceImpl;
import cn.tedu.ssm.entity.Address;
import cn.tedu.ssm.util.JsonResult;

/**
 * 收货地址控制器类
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("address")
public class AdressController extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		// 	修改收货地址
		@RequestMapping("upAddress.do")
		@ResponseBody // 返回json需要添加的注解
		public JsonResult<Void> upAddress(Address address) {
		 new AdressSerivceImpl().updateAddress(address);
			return new JsonResult (SUCCESS);
		}
	
	
	// 回填地址信息
	@RequestMapping("address.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<List<Address>> findAddress(HttpServletRequest request) {
		List<Address> list = new AdressSerivceImpl().findAdress(getUid(request));
		return new JsonResult<List<Address>>(list, SUCCESS);
	}
	
	// 添加收货地址
	@RequestMapping("addNew.do")
	@ResponseBody // 返回json需要添加的注解
	public JsonResult<Void> addNewAddress(Address address,HttpServletRequest request) {
		address.setUid(getUid(request));
		new AdressSerivceImpl().insertAddress(address);
		return new JsonResult(SUCCESS);
	}
	
	// 设为默认
	@RequestMapping("default.do")
	public String updateDefault(Integer aid) {
		new AdressSerivceImpl().updateByAid(aid);
		return "redirect:/TeduStore/web/address.html";
	}

	// 删除功能
	@RequestMapping("delete.do")
	public String deleteAddress(Integer aid) {
		new AdressSerivceImpl().deleteByAid(aid);
		return "redirect:/TeduStore/web/address.html";
	}

}
