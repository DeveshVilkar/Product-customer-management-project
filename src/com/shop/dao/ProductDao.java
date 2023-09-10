package com.shop.dao;

import com.shop.configuration.HelperClass;
import com.shop.dto.Product;

import java.sql.*;

public class ProductDao {
    HelperClass helperClass=new HelperClass();
    Connection connection=null;
    public Product insertProduct(Product product){
       connection= helperClass.makeConnection();
        try {
            PreparedStatement preparedstatement= connection.prepareStatement("INSERT INTO product VALUES(?,?,?)");
            preparedstatement.setInt(1,product.getId());
            preparedstatement.setString(2,product.getName());
            preparedstatement.setInt(3,product.getCost());
            preparedstatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
    }
//    to delete product
    public boolean deleteProduct(int id){
        connection= helperClass.makeConnection();
        try {
            PreparedStatement preparedstatement=connection.prepareStatement("DELETE FROM product WHERE id=? ");
            preparedstatement.setInt(1,id);
            preparedstatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    return true;
    }
//    update data
    public boolean updateData(String name,int cost,int id){
        connection=helperClass.makeConnection();
        try {
            PreparedStatement preparedstatement=connection.prepareStatement("UPDATE product SET name=?, cost=? WHERE id=? ");
            preparedstatement.setString(1,name);
            preparedstatement.setInt(2,cost);
            preparedstatement.setInt(3,id);
            preparedstatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
//    TO FETCH SINGLE PRODUCT
    public boolean selectProduct(int id){
        connection=helperClass.makeConnection();
        try {
            PreparedStatement preparedstatement=connection.prepareStatement("SELECT* FROM product WHERE id=?");
            preparedstatement.setInt(1,id);
            ResultSet rs =preparedstatement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
//    TO SELECT ALL PRODUCT DATA
    public boolean selectAll(String tablename){
        String sql="SELECT * FROM "+tablename;
        connection=helperClass.makeConnection();
        try {
            Statement st =connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println("product id :"+rs.getInt(1));
                System.out.println("product name :"+rs.getString(2));
                System.out.println("price :"+rs.getInt(3));
                System.out.println("====================");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    return true;
    }



}
