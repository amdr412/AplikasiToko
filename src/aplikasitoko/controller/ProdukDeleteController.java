/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.model.BarangModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class ProdukDeleteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    BarangModel barangModel = new BarangModel();
    
    @FXML
    Label kode_barang, nama_barang;
    
    @FXML
    public void hapuskan_action(ActionEvent event) throws SQLException{
        barangModel.deleteProdukData(ProdukController.kode_barang_pub);
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    public void batal_action(ActionEvent event){
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        kode_barang.setText(ProdukController.kode_barang_pub);
        nama_barang.setText(ProdukController.nama_barang_pub);
    }    
    
}
