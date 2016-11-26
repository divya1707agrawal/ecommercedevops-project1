package ShoppingCartBackend;



import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.controller.Category;
import com.niit.shoppingcart.controller.CategoryDAO;



public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Category category;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		category=(Category) context.getBean("category");
	}
	@Test
	public void createCategoryTestCase()
	{
		category.setId("NOB_07");
		category.setDescription("This is mobile category");
		category.setName("mob category");
	    Boolean status=categoryDAO.save(category);
	    Assert.assertEquals("create Category Test Case",true,status);
	}
	@Test
	public void deleteCategoryTestCase()
	{
		category.setId("MOB_07");
		Boolean status=categoryDAO.delete(category);
		Assert.assertEquals("Delete Category Test Case",true,status);
	}
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("MOB_07");
		category.setDescription("This is mobile category");
		Boolean status=categoryDAO.update(category);
		Assert.assertEquals("Update Category Test Case",true,status);
	}
	@Test
	public void getCategoryTestCase()
	{
		Assert.assertEquals("Get Category Test Case",null,categoryDAO.get("abcd"));
	}
	@Test
	public void getAllCategoryTestCase()
	{
		Assert.assertEquals("Get All Category Test Case",12,categoryDAO.list().size());
	}
	
	}


