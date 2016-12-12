package com.niit.shoppingcart;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.CartDAO;
import com.niit.shoppingcart.controller.MyCart;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;
@Controller
public class CartController {

@Autowired
CartDAO cartDAO;
	
@Autowired
MyCart myCart;
	
@Autowired
ProductDAO productDAO;
	
@RequestMapping(value="/myCart",method=RequestMethod.GET)
public String myCart(Model model,HttpSession session)
{
	System.out.println("here");
	model.addAttribute("myCart",new MyCart());
	String loggedInUserid=(String) session.getAttribute("loggedInUserID");
	if(loggedInUserid==null)
	{
	  Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	  loggedInUserid=auth.getName();
	}
	  int cartSize=cartDAO.list(loggedInUserid).size();
	  if(cartSize==0)
	  {
	   model.addAttribute("errorMessage","you do not have any products in your myCart");
	  }
	  else
	  {
	   model.addAttribute("cartList",cartDAO.list(loggedInUserid));
	   model.addAttribute("totalAmount",cartDAO.getTotalAmount(loggedInUserid));
	   model.addAttribute("displaycart","true");
       }
			return "/homepage";
 }
	@RequestMapping(value="/myCart/add",method=RequestMethod.GET)
	public ModelAndView addToCart(@PathVariable("id") String id,HttpSession session)
	{
	  Product product=productDAO.get(id);
	  myCart.setPrice(product.getPrice());
	  myCart.setProductName(product.getName());
	  String loggedInUserid=(String) session.getAttribute("loggedInUserId");
	  if(loggedInUserid==null)
	  {
	  Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	  loggedInUserid=auth.getName();
	  }
	  myCart.setUserID(loggedInUserid);
	  myCart.setStatus('N');
	 // myCart.setId(ThreadLocalRandom.current().nextLong(100,1000000+1));
	  cartDAO.save(myCart);
		ModelAndView mv=new ModelAndView("redirect:/homepage");
        mv.addObject("successMessage","successfully add the product to myCart ");
        return mv;
	}
	@RequestMapping("myCart/delete/{id}")
	public String removeCart(@PathVariable("id") String id,ModelMap model) throws Exception
	{
		try{
			cartDAO.delete(id);
			model.addAttribute("message","successfully remove");
		}
		catch(Exception e){
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
			}
		return  "redirect:/homepage";
	}
	
	}
	
