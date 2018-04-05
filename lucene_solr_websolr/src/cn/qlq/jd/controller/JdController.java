package cn.qlq.jd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.qlq.jd.pojo.ProductModel;
import cn.qlq.jd.service.JdService;

/**
 * 查询商品列表
 *
 */
@Controller
public class JdController {
	@Autowired
	private JdService jdService;

	// 商品列表
	@RequestMapping(value = "/list.action")
	public String list(String queryString, String catalog_name, String price, String sort, Model model)
			throws Exception {
		// 通过上面四个条件查询对象商品结果集
		List<ProductModel> productModels = jdService.selectProductModelListByQuery(queryString, catalog_name, price,
				sort);
		model.addAttribute("productModels", productModels);
		// 查询条件回显
		model.addAttribute("queryString", queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);

		return "product_list";
	}
}
