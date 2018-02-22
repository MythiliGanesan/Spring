package com.cts.product.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@Controller
public class ProductController {
	@org.springframework.beans.factory.annotation.Autowired(required=true)
	private ProductService saveService;

	@RequestMapping("saveProduct")
	public String saveProduct(Model model, @ModelAttribute("cmdName") Product prod) {

		saveService.saveProduct(prod);
		System.out.println("Controller Done");
		return "info";
	}

	@RequestMapping("listProds")
	public String listAll(Model model) {

		List<Product> prods = saveService.listProds();
		model.addAttribute("products", prods);

		return "displayproducts";
	}
}
