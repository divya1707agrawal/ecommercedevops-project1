package com.niit.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.Supplier;
import com.niit.shoppingcart.controller.SupplierDAO;
import com.niit.shoppingcart.util.FileUtil;

public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Product product;
	
	@Autowired(required=true)
	private SupplierDAO supplieryDAO;
	
	//private String path="D:\\shoopingCart\\Images";
	
	@RequestMapping(value="manage_products",method=RequestMethod.GET)
	public String listProducts(Model model)
	{
	// log.debug("String of the method listProducts");
	 model.addAttribute("product",new Product());
	 /*model.addAttribute("category",new Category());
	  * model.addAttribute("supplier",new Supplier());*/
	 model.addAttribute("productList",this.productDAO.list());
	 /*model.addAttribute("categoryList",this.categoryDAO.list());
	  * model.addAttribute("supplierList",this.supplierDAO.list());*/
	   model.addAttribute("isAdminClickedProducts","true");
      //  log.debug("Ending of the method listProducts");
	     return "/home";
	}
	
	 //for add and update product both
	@RequestMapping(value="manage_products",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image") MultipartFile file,Model model)
	{
	/*//log.debug("Starting of the method addProduct");
	Category category=categoryDAO.getByName(product.getCategory().getName());
	//categoryDAO.saveOrUpdate(category);//why to save??
	
	Supplier supplier=supplierDAO.getByName(product.getSupplier().getName());
	//categoryDAO.saveOrUpdate(category);//why to save??
	
	product.setCategory(category);
	product.setSupplier(supplier);
	//product.setCategory_id(category.getId());
	//product.setSupplier_id(supplier.getId());
	product.setId(com.niit.shoppingcart.util.Util.removeCommon(product.getId()));
	productDAO.saveorupdate(product);
	FileUtil.upload(path,file,product.getId()+".jpg");
	log.debug("Ending of the method addProduct");
	model.addAttribute("isAdminClickedProducts","true");
	model.addAttribute("productList",this.productDAO.list());
	model.addAttribute("product",new Product());
	return "/home";*/
		return null;
	}
}
