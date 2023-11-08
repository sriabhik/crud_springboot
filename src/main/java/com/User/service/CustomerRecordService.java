package com.User.service;

import com.User.entities.CustomerRecord;
import com.User.repository.CustomerRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerRecordService {

    @Autowired
    private CustomerRecordRepo customerRecordRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    //create
     public CustomerRecord createCustomer(CustomerRecord saveData){

         CustomerRecord customerData = new CustomerRecord();
         customerData.setCustName(saveData.getCustName());
         customerData.setMobileNumber(saveData.getMobileNumber());
         customerData.setEmail(saveData.getEmail());
         customerData.setPassword(this.passwordEncoder.encode(saveData.getPassword()));
         CustomerRecord dataSaved = this.customerRecordRepo.save(customerData);
         return dataSaved;

     }

    //read  custId = 10  -> customerRecord : name,mobileNumber
    public CustomerRecord customerById(int custId){

        CustomerRecord customerData =  this.customerRecordRepo.findById(custId).get();
        return customerData;
    }

    //update
    public CustomerRecord updateCustomer(int custId,CustomerRecord dataUpdate){
        CustomerRecord data =  this.customerRecordRepo.findById(custId).get();
        CustomerRecord newData = new CustomerRecord();
        if(data.getCustName()!=null){

                newData.setCustId(custId);

                newData.setCustName(dataUpdate.getCustName());
                newData.setMobileNumber(dataUpdate.getMobileNumber());
                newData.setEmail(dataUpdate.getEmail());
                newData.setPassword(this.passwordEncoder.encode(dataUpdate.getPassword()));
                this.customerRecordRepo.save(newData);
        }
        else{
            System.out.println("User with user id : "+ custId + " not found");
        }

        return newData;
    }

    //delete
    public String deleteCustomer(int custId){
         this.customerRecordRepo.deleteById(custId);
         return "User deleted with id :"+ custId + " successfully !!";
    }
}


