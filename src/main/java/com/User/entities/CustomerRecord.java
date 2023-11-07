package com.User.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int custId;
    @Column(name = "name",length = 30)
    private String custName;
    @Column(name = "contact",length = 10)
    private String mobileNumber;
}
