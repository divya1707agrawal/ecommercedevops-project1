import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.shoppingcart.controller.Product;

public class OrderWebflow {

	@Autowired
	 HttpSession httpSession;
	
	@Autowired
	Product product;
	
	public Order initFlow(){
		order=new Order();
		return order;
	}
	
	public String addShippingAddress(Order order,ShippingAddress shippingAddress){
		order.setShippingAddress(shippingAddress);
		return "success";
	}
	
	public String addBillingAddress(Order order,ShippingAddress shippingAddress){
		order.setBillingAddress(shippingAddress);
		return "success";
	}
	
	public String paymentMethod(Order order,ShippingAddress shippingAddress){
		order.setBillingAddress(shippingAddress);
		return "success";
	}
}
