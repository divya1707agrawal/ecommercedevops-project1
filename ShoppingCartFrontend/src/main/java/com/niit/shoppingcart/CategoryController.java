package com.niit.shoppingcart;

import org.springframework.ui.Model;

public class CategoryController {
	
	
	
	
	
	
	
	
	
	
//private String path="D:\\shoppingcart\\img";
	
	@RequestMapping(value="/manage_categories",method=RequestMethod.GET)
	public String listCategory(Model model){
		log.debug("Starting of the method list Categories");
	    model.addAttribute("category",category);
	    model.addObject("categoryList",categoryDAO.List());
	    model.addObject("isAdminClickedCategory","true");
	    log.debug("end of the method listCategories");
	    return "/homepage";
	}
     
	@RequestMapping(value="manage_category_add",method=RequestMethod.POST)
	public string addCategory(@ModelAttribute("category") category category,Model model){
		log.debug("starting of the method addCategory");
		log.debug("id:"+category.getId());
		if(categoryDAO.saveOrUpdate(category)==true){
			model.addAttribute("msg","Successfully created/update the category");
		}else{
			model.addAttribute("msg","not able to created/update the category";
		}
		model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("isAdminClickedCategory","true");
		log.debug("Ending of the method addCategory");
		return "/homepage";
		}
	}
}
