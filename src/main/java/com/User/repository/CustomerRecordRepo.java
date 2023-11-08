package com.User.repository;

import com.User.entities.CustomerRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRecordRepo extends JpaRepository<CustomerRecord,Integer> {

    CustomerRecord findByEmail(String email);


}
