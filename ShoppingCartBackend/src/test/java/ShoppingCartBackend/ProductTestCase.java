package ShoppingCartBackend;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.controller.Product;
import com.niit.shoppingcart.controller.ProductDAO;

public class ProductTestCase {
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Product Product;
	
	@Autowired
	static ProductDAO ProductDAO;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		ProductDAO=(ProductDAO) context.getBean("ProductDAO");
		Product=(Product) context.getBean("Product");
	}
	@Test
	public void createProductTestCase()
	{
		Product.setId("NOB_07");
		Product.setDescription("This is mobile Product");
		Product.setName("mob Product");
	    Boolean status=ProductDAO.save(Product);
	    Assert.assertEquals("create Product Test Case",true,status);
	}
	@Test
	public void deleteProductTestCase()
	{
		Product.setId("MOB_07");
		Boolean status=ProductDAO.delete(Product);
		Assert.assertEquals("Delete Product Test Case",true,status);
	}
	@Test
	public void updateProductTestCase()
	{
		Product.setId("MOB_07");
		Product.setDescription("This is mobile Product");
		Boolean status=ProductDAO.update(Product);
		Assert.assertEquals("Update Product Test Case",true,status);
	}
	@Test
	public void getProductTestCase()
	{
		Assert.assertEquals("Get Product Test Case",null,ProductDAO.get("abcd"));
	}
	@Test
	public void getAllProductTestCase()
	{
		Assert.assertEquals("Get All Product Test Case",12,ProductDAO.list().size());
	}

}
