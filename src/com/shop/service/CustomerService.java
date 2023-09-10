package com.shop.service;

import com.shop.dao.CustomerDao;
import com.shop.dto.Customer;

public class CustomerService {
    CustomerDao customerDao=new CustomerDao();
    public Customer insertData(Customer customer){
        return customerDao.insertData(customer);
    }
    public boolean deleteData(int id){
        return customerDao.deleteData(id);
    }
    public boolean updateData(String name,String date,int id){
        return customerDao.updateData(name, date, id);
    }
    public boolean selectSingleData(int id){
        return customerDao.selectSingleData(id);
    }
    public boolean allData(String tablename ){
        return customerDao.allData(tablename);
    }
}
