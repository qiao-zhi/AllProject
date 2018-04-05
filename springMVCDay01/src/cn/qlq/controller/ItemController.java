package cn.qlq.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.qlq.pojo.Items;


/**
 * 商品管理
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {

	//入门程序 第一   包类 + 类包 + 方法名
	// @RequestMapping：里面放的是请求的url，和用户请求的url进行匹配
	// action可以写也可以不写,看前段控制器拦截的格式
	@RequestMapping(value = "/itemlist.action")
	public ModelAndView itemList(){
		
		// 创建页面需要显示的商品数据
		List<Items> list = new ArrayList<Items>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));
		
		ModelAndView mav = new ModelAndView();
		//数据,也就是跳转到下面的页面时候显示的页面
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	
}
