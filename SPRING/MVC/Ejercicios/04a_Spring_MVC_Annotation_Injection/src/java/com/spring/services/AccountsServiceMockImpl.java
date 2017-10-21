package com.spring.services;

import com.spring.domain.Book;
import com.spring.domain.Customer;

public class AccountsServiceMockImpl
    implements AccountsService
{
    @Override
    public void raiseInvoice( Book requiredBook )
    {
        // a very basic implementation for testing
        System.out.println( "Raised the invoice for " + requiredBook );
    }

    @Override
    public Customer findCustomer( String id ) throws CustomerNotFoundException
    {
        if ( id.equals( "1" ) ) {
            return new Customer( "Fred Jackson" );
        }
        else {
            throw new CustomerNotFoundException();
        }
    }
}
