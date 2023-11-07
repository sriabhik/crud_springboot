package com.User.exception;

public class CustomerNotFoundException extends RuntimeException{

    int custId;

    public CustomerNotFoundException(int custId){
        super("Customer not found with custId : "+ custId+ " into database");
        this.custId = custId;
    }

}
