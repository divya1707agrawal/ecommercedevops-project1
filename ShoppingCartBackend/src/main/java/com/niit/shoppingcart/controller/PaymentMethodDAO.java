package com.niit.shoppingcart.controller;
import java.util.*;
public interface PaymentMethodDAO {
	public List  getPaymentStatus();
    public String update(String id);
}
