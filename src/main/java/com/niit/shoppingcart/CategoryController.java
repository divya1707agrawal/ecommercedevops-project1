package com.niit.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.Supplier;
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
	
	//edit page
    @RequestMapping(value="manage_category1",method=RequestMethod.POST)
    public ModelAndView editc(@ModelAttribute("editc") Category category,Model model)
    {
   	 
   	 if(categoryDAO.update(category)==true){
 			model.addAttribute("msg","Successfully update the category");
 			ModelAndView obj=new ModelAndView("category");
			java.util.List<Category> list=categoryDAO.list();
			obj.addObject("list", list);
			return obj;
 		}
   	 else {
 			model.addAttribute("msg","not able to update the category");
 			ModelAndView obj=new ModelAndView("category");
			java.util.List<Category> list=categoryDAO.list();
			obj.addObject("list", list);
			return obj;
 		} 
    }

    @ModelAttribute("editc")
    public Category getCategory1()
    {
   	return new Category(); 
    }
    
    
	/*@RequestMapping("manage_category/edit/{id}")
   	public ModelAndView editCategory(@PathVariable("id") String id)
   	{
   	category=categoryDAO.get(id);
   	
   	ModelAndView obj=new ModelAndView("/edit");
   	obj.addObject("selectedCategory",category);
   	return obj;
   	} */
    
    
    //for going to edit page
   	@RequestMapping(value="/editcategory", method=RequestMethod.GET)
   	public ModelAndView editCate(@RequestParam("id")String id)
   	{
   	Category c=categoryDAO.get(id);
    
   	ModelAndView obj=new ModelAndView("editcategory");
   	obj.addObject("category",c);
   	return obj;
   	} 
	
	  @RequestMapping(value="/manage_category_remove",method=RequestMethod.GET)
	 	public String delete(@RequestParam("id")String id,ModelMap model)throws Exception
	 	{try{
	 	Category category=categoryDAO.get(id);
	 	System.out.println(category.getName());
	 	 categoryDAO.delete(category);
	 	 System.out.println(category.getId());
	 	 model.addAttribute("message","successfully deleted");
 		}
 		catch(Exception e)
 		{
 			model.addAttribute("message",e.getMessage());
 	 		e.printStackTrace();	
 		}
 	  return "redirect:/category";
	 		
	 	}
}

