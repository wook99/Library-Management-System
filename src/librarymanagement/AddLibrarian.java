/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tharindi
 */
public class AddLibrarian {
    public void manage(char operation,String Name,String NIC_No,String Birthday,String Gender,String Address,String TPNo,String Email,String Username,String Password){
        Connection conn=MyConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        if(operation=='i'){
            try {
                ps=conn.prepareStatement("INSERT INTO librarian(Name, NIC_No, Birthday, Gender, Address, TPNo, Email,Username,Password) VALUES (?,?,?,?,?,?,?,?,?) ");
                ps.setString(1, Name);
                ps.setString(2,NIC_No);
                ps.setString(3,Birthday);
                ps.setString(4,Gender);
                ps.setString(5,Address);
                ps.setString(6,TPNo);
                ps.setString(7,Email);
                ps.setString(8,Username);
                ps.setString(9,Password);
                //ps.execute();
                if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "New Record Added");
                
                }
                        
            
        
        } catch (SQLException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }}
        else if(operation=='d'){
        
            try {
                ps=conn.prepareStatement("DELETE FROM `librarian` WHERE `NIC_No`=?");
                
                ps.setString(1, NIC_No);
                //ps.execute();
                if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Record Deleted");
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
        }
    
    
    
    }
public void displayTable(JTable table){
        Connection con=MyConnection.getConnection();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT * FROM `librarian`");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model= (DefaultTableModel)table.getModel();
            Object [] row= new Object[9];
            model.setRowCount(0);
            while(rs.next()){
            row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            row[7] = rs.getString(8);
            row[8] = rs.getString(9);
            
            model.addRow(row);
            }
    }   catch (SQLException ex) {   
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    

}
        