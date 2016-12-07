package com.niit.shoppingcart.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdvice
public class shoppingcartExceptionHandler {


	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView dbServerNotAtarted(HttpServletRequest request,Exception e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errormessage","e.getMessage()");
		return mv;
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request,Exception e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errormessage","e.getMessage()");
		return mv;
	}
	
	@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView handleQuerySyntaxException(HttpServletRequest request,Exception e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errormessage","e.getMessage()");
		return mv;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView notHandlerException(HttpServletRequest request,Exception e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errormessage","e.getMessage()");
		return mv;
	}
	
	@ExceptionHandler(IOException.class)
	public ModelAndView handlerIOException(HttpServletRequest request,Exception e){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errormessage","e.getMessage()");
		return mv;
	}
	
}
