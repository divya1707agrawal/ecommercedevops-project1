package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
@Controller
public class CategoryController {
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	
	
	
	
	
//private String path="D:\\shoppingcart\\img";
	
	@RequestMapping(value="/manage_categories",method=RequestMethod.GET)
	public String listCategory(Model model){
		//log.debug("Starting of the method list Categories");
	    model.addAttribute("category",category);
	    
	    model.addAttribute("categoryList",categoryDAO.catlist());
	    model.addAttribute("isAdminClickedCategory","true");
	  //  log.debug("end of the method listCategories");
	    return "/homepage";
	}
	@RequestMapping("/category")
	public ModelAndView addcategory()
	{
		ModelAndView obj=new ModelAndView("category");
		List<Category>	list=	categoryDAO.list();
		obj.addObject("list", list);
		return obj;
		
	}
     @ModelAttribute("category")
     public Category getCategory()
     {
    	return new Category(); 
     }
	@RequestMapping(value="manage_category_add",method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category category,Model model){
		//log.debug("starting of the method addCategory");
		System.out.println(category.getId());
	//	log.debug("id:"+category.getId());
		if(categoryDAO.saveOrUpdate(category)==true){
			model.addAttribute("msg","Successfully created/update the category");
			ModelAndView obj=new ModelAndView("category");
			List<Category>	list=	categoryDAO.list();
			obj.addObject("list", list);
			return obj;
		}else{
			model.addAttribute("msg","not able to created/update the category");
			ModelAndView obj=new ModelAndView("category");
			List<Category>	list=	categoryDAO.list();
			obj.addObject("list", list);
			return obj;
		
		}
		/*model.addAttribute("category",category);
		model.addAttribute("categoryList",categoryDAO.list());
		model.addAttribute("isAdminClickedCategory","true");
	//	log.debug("Ending of the method addCategory");
		return "/homepage";*/
		}

}

