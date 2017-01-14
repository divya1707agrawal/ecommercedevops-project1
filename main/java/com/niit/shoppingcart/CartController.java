package com.niit.shoppingcart;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.CartDAO;
import com.niit.shoppingcart.controller.MyCart;
import com.niit.shoppingcart.controller.PaymentMethodDAO;
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
	
	@Autowired
	HttpServletRequest request;
 
	 @Autowired
	 PaymentMethodDAO p;
	@RequestMapping(value = "/myCart/cart", method = RequestMethod.GET)
	public String myCart(Model model, HttpSession session) {
		System.out.println("here");
		model.addAttribute("myCart", new MyCart());
	Integer i=	(Integer) session.getAttribute("uid");
		String loggedInUserid = i.toString();
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
		}
		int cartSize = cartDAO.list(loggedInUserid).size();
		if (cartSize == 0) {
			model.addAttribute("errorMessage", "you do not have any products in your myCart");
		} else {
			model.addAttribute("cartList", cartDAO.list(loggedInUserid));
			System.out.println("here8" );
			double d=cartDAO.getTotalAmount(loggedInUserid);
			model.addAttribute("totalAmount", d);
			session.setAttribute("totalamount", d);
			
			model.addAttribute("displaycart", "true");
		}
		return "/cart";
	}
	

	@RequestMapping(value = "/myCart/add", method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam("id") String id, HttpSession session) {
		System.out.println("here-1 " + id);
		Product product = productDAO.get(id);

		myCart = new MyCart();
		myCart.setPrice(productDAO.get(id).getPrice());
		System.out.println("here1");
		myCart.setProductName(product.getName());
		System.out.println("here2");
		String loggedInUserid = (String) session.getAttribute("loggedInUserId");
		if (loggedInUserid == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			loggedInUserid = auth.getName();
			System.out.println(loggedInUserid);
		}
		
		Integer uid=(Integer)session.getAttribute("uid");
		myCart.setUserID(uid.toString());
		myCart.setStatus('N');
		myCart.setQuantity(1);
		// myCart.setId(ThreadLocalRandom.current().nextLong(100,1000000+1));
		Integer i=cartDAO.save(myCart);
		ModelAndView mv = new ModelAndView("Success");
		
		mv.addObject("successMessage", "successfully add the product to myCart ");
		
		HttpSession s=request.getSession();
		   if(s!=null){
			 s.setAttribute("cart_id",i);
		   }
		   double d=cartDAO.getTotalAmount(uid.toString());
		   session.setAttribute("totalamount", d);
		return mv;
	}
	
	@RequestMapping(value="/homepage")
	public String gotohomepage()
	{
		return "homepage";
	}
	
	 @ModelAttribute("Success")
     public Product getProduct1()
     {
    	return new Product(); 
     }
	 
	 
	 @RequestMapping("/myCart/delete")
	 	public String removeCart(@RequestParam("id") int id,ModelMap model)throws Exception
	 	{
	 		try{
	 			cartDAO.delete(id);
				model.addAttribute("message","successfully remove");
	 		}
	 		catch(Exception e){
	 		model.addAttribute("message",e.getMessage());
	 		e.printStackTrace();	
	 }
	 	return  "redirect:/myCart/cart";
	 }

	 @RequestMapping("/paymentmethod/status")
	 public String updatestatus(@RequestParam("id") String id,ModelMap model)throws Exception
	 {String message="";
		 try{
			 System.out.println("status updated1");
			  message=p.update(id);
			 model.addAttribute("message","successfully remove");	
			 System.out.println("status updated2");
			 System.out.println(message);
		 }
		 catch(Exception e)
		 {
			 model.addAttribute("message",e.getMessage());
			 System.out.println(e.getMessage());
			 
		 }
	 return "redirect:/paymentConfirmed";
	 }
	 
	@RequestMapping("/paymentgateway")
	public ModelAndView payment(Model model)
	{
		ModelAndView mv=new ModelAndView("paymentgateway");
		return mv;
	}
	
	@RequestMapping("/paymentConfirmed")
	public ModelAndView paymentconfirm(Model model)
	{
	java.util.List lst=	p.getPaymentStatus();
	
		ModelAndView mv=new ModelAndView("paymentConfirmed");
	model.addAttribute("paymentmethod", lst);
		return mv;
	}
}