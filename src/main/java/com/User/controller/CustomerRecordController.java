package com.User.controller;


import com.User.entities.CustomerRecord;
import com.User.service.CustomerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerRecordController {

    @Autowired
    private CustomerRecordService customerRecordService;


    //create
    @PostMapping("/create")
    public CustomerRecord createCutomer(@RequestBody CustomerRecord customerRecord){
           return  this.customerRecordService.createCustomer(customerRecord);
    }

    //read
    @GetMapping("/getCustomer/{custId}")
    public CustomerRecord getCustomerById(@PathVariable Integer custId){
        return this.customerRecordService.customerById(custId);
    }

    //update
    @PutMapping("/update/{custId}")
    public CustomerRecord updateCustomerRecord(@PathVariable Integer custId,@RequestBody CustomerRecord customerRecord){
        return this.customerRecordService.updateCustomer(custId,customerRecord);
    }

    //delete
    @DeleteMapping("/delete/{custId}")
    public String  deleteCustomer(@PathVariable int custId){
        return this.customerRecordService.deleteCustomer(custId);
    }

}
