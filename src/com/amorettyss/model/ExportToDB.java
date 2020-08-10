package com.amorettyss.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExportToDB {

        public void Export (JTable table) { //we create here an JTable to create the process! But by Cotroller we call the Table of AppGui
                Connect con = new Connect();
                PreparedStatement ps;
                int numeroFila = table.getRowCount();
                int numeroColumna = table.getColumnCount();
                int indexRowDB; //for the assignation of value on the db -> 1=designation, 2->doj and 3-> salary
                try {
                        Connection conn = con.getConnect(); //getting connection
                        JOptionPane.showMessageDialog(null, "Preparing for inset the information");
                        ps = conn.prepareStatement("INSERT INTO datos (designation, doj, salary) VALUES(?, ?, ?)"); //JQuery command
                        for (int i = 0; i < numeroFila; i++) { //-1 is the title rows. we need only the content  of the table
                                for (int j = 0; j < numeroColumna; j++) {
                                        indexRowDB = j + 1;
                                        ps.setString(indexRowDB, String.valueOf(table.getValueAt(i, j)));
                                }
                                ps.execute(); // important, not move! it work only if the row was completed with information
                        }
                        conn.close();
                        JOptionPane.showMessageDialog(null, "Eureka! Inserted in the DB");
                } catch (Exception e) {
                }
        }
}
