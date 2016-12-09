package com.niit.shoppingcart;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;
import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.Supplier;
import com.niit.shoppingcart.controller.SupplierDAO;

@Controller
public class SupplierController {

	
	@Autowired 
	private SupplierDAO supplierDAO;
	
	@Autowired 
	private Supplier supplier;
	

	@RequestMapping(value="/manage_suppliers",method=RequestMethod.GET)
	public String listSuppliers(Model model){
	    model.addAttribute("supplier",supplier);
	     model.addAttribute("supplierList",supplierDAO);
	    model.addAttribute("isAdminClickedSupplier","true");
	    return "/homepage";
	}
	@RequestMapping("/supplier1")
	public ModelAndView addsupplier()
	{

		ModelAndView obj= new ModelAndView("supplier1");
		java.util.List lst=supplierDAO.list();
		obj.addObject("list", lst);
		return obj;
	}
     @ModelAttribute("supplier")
     public Supplier getSupplier()
     {
    	return new Supplier(); 
     }
	@RequestMapping(value="manage_supplier_add",method=RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute("supplier") Supplier supplier,Model model)
	{
		System.out.println(supplier.getId());
		if(supplierDAO.saveOrUpdate(supplier)==true)
		{
			model.addAttribute("msg","Successfully created/update the supplier");
			ModelAndView obj=new ModelAndView("supplier");
			java.util.List<Supplier>	list=supplierDAO.list();
			obj.addObject("list", list);
			return obj;
		}else{
			model.addAttribute("msg","not able to created/update the supplier");
			ModelAndView obj=new ModelAndView("supplier");
			java.util.List<Supplier>	list=supplierDAO.list();
			obj.addObject("list", list);
			return obj;
		}
		/*model.addAttribute("supplier",supplier);
		model.addAttribute("supplierList",supplierDAO.list());
		model.addAttribute("isAdminClickedSupplier","true");
		return "/homepage";*/
	}
	
	/*@RequestMapping("manage_supllier_remove/{id}")
	public String deleteSupplier(Supplier supplier)
	{
	boolean flag=supplierDAO.delete(supplier);
	String msg="successfully done the operation";
	if(flag!=true){
		msg="The operation could not success";
	}
	return msg;
}*/	
  	@RequestMapping("manage_supplier/edit/{id}")
   	public ModelAndView editSupplier(@PathVariable("id") String id)
   	{
   	supplier=supplierDAO.get(id);
   	
   	ModelAndView obj=new ModelAndView("/edit");
   	obj.addObject("selectedSupplier",supplier);
   	return obj;
   	} 
	
	
	@RequestMapping(value="manage_supllier_remove",method=RequestMethod.GET)
	public @ResponseBody String delete(@RequestParam("id")String id)
	{
		Supplier supplier=supplierDAO.get(id);
	System.out.println(supplier.getName());
	 supplierDAO.delete(supplier);
	 
		return "deleted Successfully";
		
	}
}