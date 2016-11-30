package com.niit.shoppingcart;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.User;

@Controller
public class HomeController {
	
	//public static Logger log=LoggerFactory.getLogger(HomeController.class);
	
	@Autowired 
	private Category category;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@Autowired 
	UserDAO userDAO;
	
	@Autowired 
	User user;
	
	@Autowired 
	private CartDAO cartDAO;
	
	@Autowired 
	private Cart cart;
	
	@Autowired 
	private CategoryDAO categorDAO;
	
	@Autowired 
	private SupplierDAO supplierDAO;
	 
	@Autowired 
	private Supplier supplier;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView index()
	public ModelAndView onLoad(HttpSession session){
		log.debug("Starting of the method onLoad");
		ModelAndView mv=new ModelAndView("/homepage");
		session.setAttribute("category",category);
		session.setAttribute("product",product);
		session.setAttribute("supplier",supplier);
		session.setAttribute("categoryList",categoryDAO.list());
		session.setAttribute("supplierList",supplierDAO.list());
		log.debug("Ending of the method onLoad");
		return mv;
	}
@RequestMapping("/login")
public ModelAndView login(){
	log.debug("Starting of the method login");
	System.out.println("login");
	ModelAndView mv=new ModelAndView("/homepage");
	mv.addObject("user",user);
	mv.addobject("isUserClickedlogin","true");
	log.debug("Ending of the method login");
	return mv;
}
@RequestMapping("/register")
public ModelAndView register(){
	log.debug("Starting of the method register");
	ModelAndView mv=new ModelAndView("/homepage");
	mv.addObject("user","user");
	mv.addObject("isUserClickedRegister","true");
    log.debug("Ending of the method register");
	return mv;
	}
@RequestMapping("/validate")
public String validate(@RequestParam(value="usr") String user ,@RequestParam(value="pwd") String pwd,Model model)
{
	if(user.equals("niit") && pwd.equals("niit"))
	{
		return "homepage";
	}
	else
	{
		model.addAttribute("errorMessage","invalid credentials...please try again");
	return "login";
	}
}
@RequestMapping(value="/viewproduct",method=RequestMethod.GET)
public @ResponseBody String viewproduct(@RequestParam(value="name") String name)
{
  java.util.List lst=productDAO.getBycatName(name);
  Gson gson=new Gson();
	String data=gson.toJson(lst);
	return data;
}
@RequestMapping("/viewproductdata")
public ModelAndView viewdata()
{
	return new ModelAndView("viewproductdata");
}


}
