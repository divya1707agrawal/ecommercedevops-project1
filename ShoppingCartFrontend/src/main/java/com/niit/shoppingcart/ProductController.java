package com.niit.shoppingcart;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.h2.util.IOUtils;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.Supplier;
import com.niit.shoppingcart.controller.SupplierDAO;
import com.niit.shoppingcart.util.FileUtil;


@Controller
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Product product;
	
	@Autowired(required=true)
	private SupplierDAO supplierDAO;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//private String path="D:\\shoopingCart\\Images";
	
	@RequestMapping(value="manage_products",method=RequestMethod.GET)
	public String listProducts(Model model)
	{
		
	// log.debug("String of the method listProducts");
	 model.addAttribute("product",new Product());
	 model.addAttribute("category",new Category());
	 model.addAttribute("supplier",new Supplier());
	 model.addAttribute("productList",this.productDAO.list());
	 model.addAttribute("categoryList",this.categoryDAO.list());
	 model.addAttribute("supplierList",this.supplierDAO.list());
	 model.addAttribute("isAdminClickedProducts","true");
      //  log.debug("Ending of the method listProducts");
	     return "/homepage";
	}
	
	
	   @RequestMapping(value="/product",method=RequestMethod.GET)
	public ModelAndView addproduct()
	{
		ModelAndView obj= new ModelAndView("product");
		java.util.List lst=productDAO.list();
		obj.addObject("list", lst);
		return obj;
	}
     @ModelAttribute("product")
     public Product getCategory()
     {
    	return new Product(); 
     }
     
     @ModelAttribute("editproduct")
     public Product getProduct()
     {
    	 return new Product();
     }
     
	 //for add and update product both
/*	@RequestMapping(value="manage_product_add",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute("product")Product product,@RequestParam("image") MultipartFile file,Model model)
	{
		System.out.println(product.getId());
		if(productDAO.saveOrUpdate(product)==true){
			model.addAttribute("msg","Successfully created/update the product");
			return "/product";
		}else{
			model.addAttribute("msg","not able to created/update the product");
		return "/product";
		}
	}*/
	//log.debug("Starting of the method addProduct");
	/*Category category=categoryDAO.getByName(product.getCategory().getName());
	categoryDAO.saveOrUpdate(category);//why to save??
	
	Supplier supplier=supplierDAO.getByName(product.getSupplier().getName());
	categoryDAO.saveOrUpdate(category);//why to save??
	
	product.setCategory(category);
	product.setSupplier(supplier);
	product.setCategory_id(category.getId());
	product.setSupplier_id(supplier.getId());
	//product.setId(com.niit.shoppingcart.util.FileUtil.removeCommon(product.getId()));
	productDAO.saveOrUpdate(product);
//	FileUtil.upload(path,file,product.getId()+".jpg");
	//log.debug("Ending of the method addProduct");
	model.addAttribute("isAdminClickedProducts","true");
	model.addAttribute("productList",this.productDAO.list());
	model.addAttribute("product",new Product());
	return "/homepage";*/
	
/*	@RequestMapping("/search_product/{search_string}")
	public List<Product> getAllProductBySearchString(PathVariable("search_string") String search_string)
    {
    		return List<Product> product=productDAO.getSimilarProducts(search_string);
    		ModelAndView mv=new ModelAndView("/home");
    		if(products.isEnpty())
    		{
    			mv.addObject("msg","No products are available with the search text:+search_string);
    		}else{
    			mv.addObject("productList",products);
    		}
    		return mv;
      }*/
  /*   @RequestMapping("/download/{productId}")
 	public String download(@PathVariable("productId")
 			Integer productId, HttpServletResponse response) {
 		
    	 Product doc = productDAO.get(productId);
 		try {
 			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
 			OutputStream out = response.getOutputStream();
 			response.setContentType(doc.getContentType());
 			IOUtils.copy(doc.getContent().getBinaryStream(), out);
 			out.flush();
 			out.close();
 		
 		} catch (IOException e) {
 			e.printStackTrace();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 		
 		return null;
 	}
     
    */ 
     
     
     
     
     @RequestMapping(value="manage_product_add",method=RequestMethod.POST)
 	public ModelAndView addProduct(@ModelAttribute("product") Product product,  @RequestParam CommonsMultipartFile[] fileUpload  ,Model model)
 	{
 		System.out.println(product.getId());
 	   
 	    if (fileUpload != null && fileUpload.length > 0) {
 	        for (CommonsMultipartFile aFile : fileUpload){
 	              
 	            System.out.println("Saving file: " + aFile.getOriginalFilename());
 	             
 	          product.setFilename(product.getName()+product.getId()+".jpeg");
 	            product.setContent(aFile.getBytes());
 	                      
 	        }
 	    }
 		if(productDAO.saveOrUpdate(product)==true){
 			model.addAttribute("msg","Successfully created/update the product");
 			ModelAndView obj=new ModelAndView("product");
			java.util.List<Product> list=productDAO.list();
			obj.addObject("list", list);
			return obj;
 		}else{
 			model.addAttribute("msg","not able to created/update the product");
 			ModelAndView obj=new ModelAndView("product");
			java.util.List<Product> list=productDAO.list();
			obj.addObject("list", list);
			return obj;
 		}
 	}
     //edit page
     @RequestMapping(value="manage_product1",method=RequestMethod.POST)
     public ModelAndView editp(@ModelAttribute("editp") Product product,@RequestParam CommonsMultipartFile[] fileUpload ,Model model)
     {
    	 if (fileUpload != null && fileUpload.length > 0) {
  	        for (CommonsMultipartFile aFile : fileUpload){
  	              
  	            System.out.println("Saving file: " + aFile.getOriginalFilename());
  	             
  	          product.setFilename(aFile.getOriginalFilename());
  	            product.setContent(aFile.getBytes());
  	                      
  	        }
  	    }
    	 
    	 if(productDAO.update(product)==true){
  			model.addAttribute("msg","Successfully update the product");
  			ModelAndView obj=new ModelAndView("product");
 			java.util.List<Product> list=productDAO.list();
 			obj.addObject("list", list);
 			return obj;
  		}
    	 else {
  			model.addAttribute("msg","not able to update the product");
  			ModelAndView obj=new ModelAndView("product");
 			java.util.List<Product> list=productDAO.list();
 			obj.addObject("list", list);
 			return obj;
  		} 
     }
     @ModelAttribute("editp")
     public Product getProduct1()
     {
    	return new Product(); 
     }
  /* @RequestMapping("manage_product/remove/{id}")
     public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception
 	{
 	    try{
      	productDAO.delete(product);
      	model.addAttribute("message","successfully Added");
      	}catch(Exception e){
      	model.addAttribute("message",e.getMessage());
      	e.printStackTrace();
      	}
      	return "forward:/manage_products";
   	}
   	
     @RequestMapping("manage_product/edit")
    	public ModelAndView editProduct(@PathVariable("id") String id)
    	{
    	product=productDAO.get(id);
    	
    	ModelAndView obj=new ModelAndView("/product");
    	obj.addObject("selectedProduct",product);
    	return obj;
    	} */
     
     
     //for going to edit page
   	@RequestMapping(value="/editproduct", method=RequestMethod.GET)
   	public ModelAndView editPr(@RequestParam("id")String id)
   	{
   	//supplier=supplierDAO.get(id);
   	Product p=productDAO.get(id);
    
   	ModelAndView obj=new ModelAndView("editproduct");
  // 	obj.addObject("selectedSupplier",supplier);
   	obj.addObject("product",p);
   	return obj;
   	} 
   	
     @RequestMapping(value="manage_product_remove",method=RequestMethod.GET)
 	public @ResponseBody String delete(@RequestParam("id")String id)
 	{
 		Product product=productDAO.get(id);
 	System.out.println(product.getName());
 	 productDAO.delete(product);
 	 System.out.println(product.getId());
 		return "deleted Successfully";
 		
 	}
}
     
     
     
  
