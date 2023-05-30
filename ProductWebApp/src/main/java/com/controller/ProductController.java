package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ProductDao;
import com.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao = new ProductDao();
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String getUrl(Model m)
	{
		List<Product> products = productDao.getProducts();
		m.addAttribute("products" , products);
		return "index";
	}
	//show form
	@RequestMapping(path="/add_product",method=RequestMethod.GET)
	public String addProduct()
	{
		return "add_product";
	}
	
	@RequestMapping(value="/handleForm",method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		this.productDao.createProduct(product);
		//redirect
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//delete
	@RequestMapping(path="/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request)
	{
		this.productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//update
	
	@RequestMapping(path="update/{pid}")
	public String updateProduct(@PathVariable("pid") int pid , Model model)
	{
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("product", product);
		return "update_product";
		
	}
}
