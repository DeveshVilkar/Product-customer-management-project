package com.shop.dao;

import com.shop.configuration.HelperClass;
import com.shop.dto.Customer;

import java.sql.*;

public class CustomerDao {
    HelperClass helperclass=new HelperClass();
    Connection connection=null;
//    to insert the data
    public Customer insertData(Customer customer){
        connection=helperclass.makeConnection();
        try {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
            preparedstatement.setInt(1,customer.getId());
            preparedstatement.setString(2, customer.getName());
            preparedstatement.setString(3,customer.getOrderdate());
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
     return customer;
    }
    public boolean deleteData(int id){
        connection=helperclass.makeConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("DELETE FROM customer WHERE id=?");
            ps.setInt(1,id);
            ps.execute();
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

//    to yupdate data
    public boolean updateData(String name,String date,int id){
        connection=helperclass.makeConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("UPDATE customer SET name=? ,orderdate=? WHERE id=?");
            ps.setString(1,name);
            ps.setString(2,date);
            ps.setInt(3,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
//    to select single data
    public boolean selectSingleData(int id){
       connection= helperclass.makeConnection();
        try {
            PreparedStatement  ps = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return true;
    }
//    to select all data
    public boolean allData(String tablename ){
        String sql="SELECT * FROM "+tablename;
        connection=helperclass.makeConnection();
        try {
            Statement st =connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.println("customer id :"+rs.getInt(1));
                System.out.println("customer name :"+rs.getString(2));
                System.out.println("date of purchase :"+rs.getString(3));
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
