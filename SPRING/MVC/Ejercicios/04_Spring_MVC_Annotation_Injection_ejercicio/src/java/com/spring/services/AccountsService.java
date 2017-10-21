package com.spring.services;

import java.util.List;

import com.spring.domain.Book;
import com.spring.domain.Customer;
import com.spring.domain.Order;

public interface AccountsService 
{
	public void raiseInvoice(Book requiredBook);
	
	public Customer findCustomer(String id) throws CustomerNotFoundException;
}
