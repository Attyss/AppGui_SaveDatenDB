package com.amorettyss.controller;

import com.amorettyss.browser.AppGui;
import com.amorettyss.model.ExportToDB;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class ControllerExportToDB implements ActionListener {
    private ExportToDB model;
    private AppGui view;
    JFileChooser selecArchivo = new JFileChooser();
    File archivo;
    int contadorAccion = 0;
    private String nam_,surn_,sex_;
    private String[] datos_;

    //Constructor
    public ControllerExportToDB(AppGui view, ExportToDB model) {
        this.view = view;
        this.model = model;
    }
    //Method to fix the choice of the format for the export documents
    public void AgregarFiltro() {
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*xls)", "xls"));
        selecArchivo.setFileFilter(new FileNameExtensionFilter("Excel (*xlsx)", "xlsx"));
    }
    //Action of the events
    public void actionPerformed(ActionEvent e) {
        contadorAccion++;
        if (contadorAccion == 1) {
            AgregarFiltro();
        }
        //Add the value to the table
        if (e.getSource() == view.addToListButton) {
            nam_ = view.name.getText(); //take the information
            surn_ = view.surname.getText();
            sex_ = view.sexBox.getSelectedItem().toString();
            String datos_ [] = {nam_,surn_,sex_}; //turn this to a list
            view.tableModel.addRow(datos_); //set the list in the model for show this
        }  //End
        //save list in DB
        if(e.getSource()==view.addToDBButton){
            model.Export(view.table1);
        }  //End
    }
}
