package com.niit.shoppingcart;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
public class UserController {
	
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
	private MyCart myCart;
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private SupplierDAO supplierDAO;
	 
	@Autowired 
	private Supplier supplier;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="username") String userID,@RequestParam(value="password") String password,HttpSession session)
{
	//log.debug("Starting of the method login");
	//log.debug("userID is{} password is {}",userID,password);
	
	ModelAndView mv=new ModelAndView("/homepage");
	if(user!=null)//if the credentials are valid,load all categories
	{
	  System.out.println("inside if ");
		//log.debug("valid Credentials");
		user=userDAO.get(userID);
		session.setAttribute("loggedInUser",user.getName());
		System.out.println("user name "+user.getName());
		session.setAttribute("loggedInUserID",user.getId());
		System.out.println("user id:"+user.getId());
		session.setAttribute("user",user);
    	if(user.getRole().equals("ROLE_ADMIN")){
			//log.debug("LOgged in as Admin");
			mv.addObject("isAdmin","true");
			session.setAttribute("supplier",supplier);
			session.setAttribute("supplierList",supplierDAO.list());
			session.setAttribute("category",category);
			session.setAttribute("categoryList",categoryDAO.list());
		}else{
		//	log.debug("Logged in as User");
			mv.addObject("isAdmin","false");
			myCart=cartDAO.get(userID);
			mv.addObject("myCart",myCart);
			//fetch the cart list based on user iD
			List<MyCart> cartList=cartDAO.list(userID);
			mv.addObject("cartList",cartList);
			mv.addObject("cartSize",cartList.size());
	      	}
		
	}else{
		//log.debug("Invalid Credentials");
		mv.addObject("invalidCredentials","true");
		
		
    	}
	//log.debug("Ending of the method login");
	return mv;
}

@RequestMapping("/logout")
public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
	//log.debug("Starting of the method logout");
	ModelAndView mv=new ModelAndView("homepage");
	session.invalidate();
	System.out.println("logout");
	session=request.getSession(true);
	session.setAttribute("category",category);
	session.setAttribute("categoryList",categoryDAO.list());
	mv.addObject("logoutMessage","you successfully logged out");
	mv.addObject("loggedOut","true");
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null){
		new SecurityContextLogoutHandler().logout(request,response,auth);
	}
	//log.debug("Ending of the method logout");
	return mv;
}

@RequestMapping("/register")
public ModelAndView register(){
	//log.debug("Starting of the method register");
	ModelAndView mv=new ModelAndView("register");

  //  log.debug("Ending of the method register");
	return mv;
	}

@RequestMapping(value="/registration",method=RequestMethod.POST)
public ModelAndView registerUser(@ModelAttribute("user") User user){
	//log.debug("Staring of the method registerUser");
	System.out.println("register");
	ModelAndView mv=new ModelAndView("homepage");
	user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		//log.debug("you are successfully register");
		mv.addObject("successMessage","you are successfully registered");
	return mv;
}

//commandname
@ModelAttribute("user")
public User getUser()
{
	return new User(); 
}


   @RequestMapping(value="loginError",method=RequestMethod.GET)
   public String loginError(Model model){
		//log.debug("Starting of the method loginError");
		model.addAttribute("errorMessage","Login Error");
		//log.debug("Ending of the method loginError");
		System.out.println("errormsg");
		return "/login";
	}
	@RequestMapping(value="/accessDenied",method=RequestMethod.GET)
	public String accessDenied(Model model){
		//log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage","you are not authorized to access this page");
		//log.debug("Ending of the method accessDenied");
		return "login";
	}

}
			
		

