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
public class AddBook {
    public void manage(String BookID,String Title,String Author,String Category,String Publisher,String Availability,String ReturnDate){
        Connection conn=MyConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
            try {
                ps=conn.prepareStatement("INSERT INTO `book`(`BookID`, `Title`, `Author`, `Category`, `Publisher`, `Availability`, `ReturnDate`) VALUES  (?,?,?,?,?,?,?) ");
                ps.setString(1, BookID);
                ps.setString(2,Title);
                ps.setString(3,Author);
                ps.setString(4,Category);
                ps.setString(5,Publisher);
                ps.setString(6,Availability);
                ps.setString(7,ReturnDate);
                //ps.execute();
                if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "New Book Added");
                
                }
                        
            
        
        } catch (SQLException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void displayTable(JTable table){
        Connection con=MyConnection.getConnection();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT * FROM `book`");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model= (DefaultTableModel)table.getModel();
            Object [] row= new Object[7];
            model.setRowCount(0);
            while(rs.next()){
            row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            row[5] = rs.getString(6);
            row[6] = rs.getString(7);
            
            model.addRow(row);
            }
    }   catch (SQLException ex) {   
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    

    
}
