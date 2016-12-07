package com.niit.shoppingcart.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller

public class BackendController {
	 @Autowired
	 CategoryDAO categoryDao;
	 
	 @Autowired
	 ProductDAO productDAO;
	 
	    @RequestMapping("/cat")
	    public @ResponseBody String handleRequest() throws Exception {
	 
	        List<Category> cate = categoryDao.list();
	      
	        String str=new ObjectMapper().writeValueAsString(cate);
	        return str;
	    }
	    @RequestMapping(value="/pr",method=RequestMethod.GET)
	    public @ResponseBody String handlePrRequest(@RequestParam("name")String name) throws Exception {
	 
	        List<Product> pr = productDAO.getBycatName(name);
	
	        Gson g= new GsonBuilder()
	                .registerTypeAdapter(Category.class, new MyTypeAdapter<Category>())
	                .create();
	        String str=g.toJson(pr);
	        return str;
	    }
   
}
