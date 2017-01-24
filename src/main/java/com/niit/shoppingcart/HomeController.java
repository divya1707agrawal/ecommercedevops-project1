package com.niit.shoppingcart;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import com.niit.shoppingcart.controller.CartDAO;
import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
import com.niit.shoppingcart.controller.MyCart;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.Supplier;
import com.niit.shoppingcart.controller.SupplierDAO;
import com.niit.shoppingcart.controller.User;
import com.niit.shoppingcart.controller.UserDAO;

@Controller
public class HomeController {
	
	//public static Logger log=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	private Category category;
	
	@Autowired
	private Product product;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@Autowired 
	UserDAO userDAO;
	
	@Autowired 
	User user;
	
	@Autowired 
	private CartDAO cartDAO;
	
	/*@Autowired 
	private MyCart cart;*/
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private SupplierDAO supplierDAO;
	 
	 
	private Supplier supplier;
	
	@Autowired 
	private HttpSession session;
	
	
	 @RequestMapping(value = "Upload", method = RequestMethod.GET)
	 public String showUploadForm(HttpServletRequest request) {
	    return "Upload";
    }
	 
	 
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session,Principal p){
		//log.debug("Starting of the method onLoad");
		if(p!=null)
		{
			System.out.println("principal created");
			System.out.println(p.getName());
	        Integer uid =userDAO.getId(p.getName());
		    System.out.println("this is user id "+uid);
		    session.setAttribute("user", p.getName());
		    session.setAttribute("uid", uid);
		}
		else
		{
			System.out.println("principal not  created");
		}
		ModelAndView mv=new ModelAndView("/homepage");
		session.setAttribute("category",category);
		session.setAttribute("product",product);
		session.setAttribute("supplier",supplier);
		session.setAttribute("categoryList",categoryDAO.list());
		session.setAttribute("supplierList",supplierDAO.list());
   
		//log.debug("Ending of the method onLoad");
		return mv;
	}
 static int i;
	
@RequestMapping("/login")
public ModelAndView login(HttpServletRequest request){
	//log.debug("Starting of the method login");

	System.out.println("login");
	System.out.println("session");
	request.setAttribute("loginclicked", i++);
	System.out.println((Integer)request.getAttribute("loginclicked"));
	ModelAndView mv=new ModelAndView("/login");
	mv.addObject("user",user);
	 
    mv.addObject("isUserClickedlogin","true");
  System.out.println(request.getParameter("j_password"));
	//log.debug("Ending of the method login");
	return mv;
}

@RequestMapping("/aboutus")
public ModelAndView aboutus(){
	ModelAndView mv=new ModelAndView("aboutus");
	return mv;
	}

@RequestMapping("/contactus")
public ModelAndView contactus(){
	ModelAndView mv=new ModelAndView("contactus");
	return mv;
	}


@RequestMapping(value="/viewproduct",method=RequestMethod.GET)
public ModelAndView viewproduct(@RequestParam(value="name") String name)
{
  java.util.List lst=productDAO.getByName(name);
  System.out.println(lst.size());
  if(lst.size()==0){
	  ModelAndView obj=new ModelAndView("homepage");
	  return obj;
  }
  ModelAndView obj=new ModelAndView("viewproduct");
  obj.addObject("prlist",lst);
  return obj;
}
@RequestMapping("/viewproductdata")
public ModelAndView viewdata()
{
	return new ModelAndView("viewproductdata");
}

@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
public String handleFileUpload(HttpServletRequest request,
        @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
      
    if (fileUpload != null && fileUpload.length > 0) {
        for (CommonsMultipartFile aFile : fileUpload){
              
            System.out.println("Saving file: " + aFile.getOriginalFilename());
             
            Product product = new Product();
            product.setFilename(aFile.getOriginalFilename());
            product.setContent(aFile.getBytes());
            productDAO.save(product);               
        }
    }

    return "Success";
}  



}
