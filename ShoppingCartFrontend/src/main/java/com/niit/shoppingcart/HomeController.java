package com.niit.shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {
	
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
}
