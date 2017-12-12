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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class KategoriDeleteController extends BaseController {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label kode_kategori, nama_kategori, pesan;

    @FXML
    public void hapuskan_action(ActionEvent event) throws SQLException {
        if (barangModel.deleteKategori(KategoriController.kode_kategori_pub)) {
            ((Node) event.getSource()).getScene().getWindow().hide();
        }else{
            pesan.setText("Kategori tidak bisa dihapus.");
            pesan.setTextFill(Color.RED);
        }
    }

    @FXML
    public void batal_action(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        kode_kategori.setText(KategoriController.kode_kategori_pub);
        nama_kategori.setText(KategoriController.nama_kategori_pub);
    }

}
