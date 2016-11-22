package ShoppingCartBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	Category category;
	
	@Autowired
	static CategoryDAO categoryDAO;
	
	@BeforeClass
	public void init()
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
	    //Assert.assertEquals("create Category Test Case",true,status);
	}

}
