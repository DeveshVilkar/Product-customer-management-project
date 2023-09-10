package com.shop.controller;

import com.shop.dto.Customer;
import com.shop.dto.Product;
import com.shop.service.CustomerService;
import com.shop.service.ProductService;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Product product=new Product();
        ProductService productservices=new ProductService();
        CustomerService customerservice=new CustomerService();
        Customer customer=new Customer();
        boolean flag =true;
        while (flag){
            System.out.println("1.to insert value in table 2.to delete value 3.to update value 4.to select single value 5.to select all the data 6.exit");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1.to insert data in product table 2.to insert data in customer table");
                    int choice1=sc.nextInt();
                    switch(choice1){
                        case 1:
                            //                    for product table
                            System.out.println("enter the id :");
                            int id=sc.nextInt();
                            product.setId(id);
                            System.out.println("enter the name :");
                            String name=sc.next();
                            product.setName(name);
                            System.out.println("enter the cost :");
                            int cost= sc.nextInt();
                            product.setCost(cost);

                            Product P=productservices.insertProduct(product);

                            if (P!=null){
                                System.out.println("inserted product successfully");
                            }
                            break;
                        case 2:
                            //                    for product table
                            System.out.println("enter the id :");
                            int custid=sc.nextInt();
                            customer.setId(custid);
                            System.out.println("enter the name :");
                            String custname=sc.next();
                            customer.setName(custname);
                            System.out.println("enter the orderdate :");
                            String order= sc.next();
                            customer.setOrderdate(order);

                            Customer c = customerservice.insertData(customer);

                            if (c!=null){
                                System.out.println("inserted customer successfully");
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.to delete data from product table 2.to delete data from customer table");
                    int choice2=sc.nextInt();
                    switch(choice2){
                        case 1:
                            System.out.println("enter the id to delete the data");
                            int delid=sc.nextInt();
                            boolean r= productservices.deleteProduct(delid);
                            if(r==true){
                                System.out.println("deleted successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the id to delete the data");
                            int delcustid=sc.nextInt();
                            boolean r1= customerservice.deleteData(delcustid);
                            if(r1==true){
                                System.out.println("deleted successfully");
                            }
                            break;
                    }
                    break;
                case 3:
                    System.out.println("1.to update data from product table 2.to update data from customer table");
                    int choice3=sc.nextInt();
                    switch (choice3){
                        case 1:
                            System.out.println("enter the id which data needs to be updated");
                            int num=sc.nextInt();
                            System.out.println("enter the name:");
                            String n=sc.next();
                            System.out.println("enter the cost:");
                            int c=sc.nextInt();
                            boolean res=productservices.updateData(n,c,num);
                            if (res==true){
                                System.out.println("updated successfully");
                            }
                           break;
                        case 2:
                            System.out.println("enter the id which data needs to be updated");
                            int num1=sc.nextInt();
                            System.out.println("enter the name:");
                            String custn=sc.next();
                            System.out.println("enter the order date:");
                            String custorderd=sc.next();
                            boolean custres=customerservice.updateData(custn,custorderd,num1);
                            if (custres==true){
                                System.out.println("updated successfully");
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1.to fetch single data from product table 2.to fetch single data from customer table");
                    int choice4=sc.nextInt();
                    switch (choice4) {
                        case 1:
                            System.out.println("enter the id which data to be fetch");
                            int number = sc.nextInt();
                            boolean result = productservices.selectProduct(number);
                            if (result == true) {
                                System.out.println("fetched successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the id which data to be fetch");
                            int custid = sc.nextInt();
                            boolean custresult = customerservice.selectSingleData(custid);
                            if (custresult == true) {
                                System.out.println("fetched successfully");
                            }
                            break;
                    }
                    break;

                case 5:
                    System.out.println("1.to fetch data from product table 2.to fetch data from customer table");
                    int choice5=sc.nextInt();
                    switch (choice5){
                        case 1:
                            System.out.println("enter the table name");
                            String tablename=sc.next();
                            boolean result1=productservices.selectAll(tablename);
                            if (result1==true){
                                System.out.println("fetched all successfully");
                            }
                            break;
                        case 2:
                            System.out.println("enter the table name");
                            String custtablename=sc.next();
                            boolean custresult1=customerservice.allData(custtablename);
                            if (custresult1==true){
                                System.out.println("fetched all successfully");
                            }
                            break;
                    }
                    break;
                case 6:
                    flag=false;
                    break;
                default:
                    System.out.println("wrong input");
            }
        }


    }
}
