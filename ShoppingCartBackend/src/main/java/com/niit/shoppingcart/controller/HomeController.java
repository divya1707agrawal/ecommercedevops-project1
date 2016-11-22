package com.niit.shoppingcart.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller

public class HomeController {
	 @Autowired
	    private CategoryDAO categoryDao;
	 
	    @RequestMapping("/cat")
	    public ModelAndView handleRequest() throws Exception {
	        List<Category> cate = categoryDao.list();
	        ModelAndView model = new ModelAndView("categoryList");
	        model.addObject("categoryList", cate);
	        return model;
	    }

}
