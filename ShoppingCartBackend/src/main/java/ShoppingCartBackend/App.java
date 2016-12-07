package ShoppingCartBackend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.shoppingcart.controller.Category;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans.xml");
    	Category obj=(Category)context.getBean("Category");
System.out.println(obj.getName());
    }
}
