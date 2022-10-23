package com.zrent.service;

import com.zrent.mapper.CustomerMapper;
import com.zrent.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Zrent
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> list(){
        return customerMapper.list();
    }

    public void add(Customer customer) {

        try{
            customerMapper.add(customer);

        }catch (Exception e){
            System.out.println(customer.getNickname()+"已经存在,不要重复保存");
            e.printStackTrace();
        }

    }
}
