/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.ValidasiField;
import aplikasitoko.model.BarangModel;
import aplikasitoko.object.KategoriObject;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class KategoriUpdateController extends BaseController {

    /**
     * Initializes the controller class.
     */
    @FXML
    TextField kode_kategori, nama_kategori;

    @FXML
    TextArea keterangan_kategori;

    @FXML
    Label pesan;

    @FXML
    public void editkan_action(ActionEvent event) {
        try {
            if (!ValidasiField.hasValue(kode_kategori.getText())) {
                pesan.setText("Kode Kategori Wajib Diisi!");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.hasValue(nama_kategori.getText())) {
                pesan.setText("Nama Kategori Wajib Diisi!");
                pesan.setTextFill(Color.RED);
            } else {
                if (barangModel.updateKategoriData(KategoriController.kode_kategori_pub, kode_kategori.getText(), nama_kategori.getText(), keterangan_kategori.getText())) {
                    pesan.setText("Data berhasil diperbarui");
                    pesan.setTextFill(Color.GREEN);
                } else {
                    pesan.setText("Data gagal diperbarui");
                    pesan.setTextFill(Color.RED);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukCreateController.class.getName()).log(Level.SEVERE, null, ex);
            pesan.setText("Data gagal diperbarui");
            pesan.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            barangModel.getKategoribyKodeKategori(KategoriController.kode_kategori_pub);
        } catch (SQLException ex) {
            Logger.getLogger(KategoriUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        KategoriObject kategori = barangModel.kategoriObs.get(0);
        
        kode_kategori.setText(kategori.getKode_kategori());
        nama_kategori.setText(kategori.getNama_kategori());
        keterangan_kategori.setText(kategori.getKeterangan_kategori());
    }

}
