package com.shop.service;

import com.shop.dao.ProductDao;
import com.shop.dto.Product;

public class ProductService {
    ProductDao productdao =new ProductDao();
    public Product insertProduct(Product product){
        return productdao.insertProduct(product);
    }
    public boolean deleteProduct(int id){
        return productdao.deleteProduct(id);
    }
    public boolean updateData(String name,int cost,int id){
        return productdao.updateData(name,cost,id);
    }
    public boolean selectProduct(int id){
        return productdao.selectProduct(id);
    }
    public boolean selectAll(String tablename){
        return productdao.selectAll(tablename);
    }


    }
