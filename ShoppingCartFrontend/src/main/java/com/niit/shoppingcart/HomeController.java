package com.niit.shoppingcart;

import javax.servlet.http.HttpSession;

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
import com.niit.shoppingcart.controller.ProductDAO;
import com.niit.shoppingcart.controller.User;

@Controller
public class HomeController {
	
	public static Logger log=LoggerFactory.getLogger(HomeController.class);
	
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
	private CategoryDAO category;
	
	@Autowired 
	private Category category;
	
	@Autowired 
	private SupplierDAO supplierDAO;
	 
	@Autowired 
	private Supplier supplier;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("homepage");
	}
@RequestMapping("/login")

public ModelAndView login()
	 {
	return new ModelAndView("login");
}
@RequestMapping("/register")
public ModelAndView register()
{
	return new ModelAndView("register");
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

@RequestMapping("/logout")
public ModelAndView logout(HttpServerRequest request){
	log.debug("Starting of the method logout");
	ModelAndView mv=new ModelAndView("/home");
	session.invalidate();
	session=request.getSession(true);
	session.setAttribute("category",category);
	session.setAttribute("categoryList",categoryDAO.list());
	mv.addObject("logoutMessage","you successfully logged out");
	mv.addObject("loggedOut","true");
	log.debug("Ending of the method logout");
    return mv;
}

@RequestMapping(value="/register",method=RequestMethod.POST)
public ModelAndView registerUser(@ModelAttribute User user){
	log.debug("Starting of the method registerUser");
	ModelAndView mv=new ModelAndView("home");
	if(userDAO.get(user.getId())==null){
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		log.debug("you are successfully register");
		mv.addObject("successMessage","you are successfully registered");
	}else{
		log.debug("User exist with this id");
	     
	}
}
}
