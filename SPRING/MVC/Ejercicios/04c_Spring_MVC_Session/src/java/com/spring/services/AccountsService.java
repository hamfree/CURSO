package com.spring.services;

import com.spring.domain.Book;
import com.spring.domain.Customer;

public interface AccountsService
{
    public void raiseInvoice( Book requiredBook );

    public Customer findCustomer( String id ) throws CustomerNotFoundException;
}
