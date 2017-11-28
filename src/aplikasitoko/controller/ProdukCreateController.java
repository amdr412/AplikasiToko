/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.model.BarangModel;
import aplikasitoko.object.KategoriObject;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class ProdukCreateController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param event
     */
    @FXML
    Label pesan;

    @FXML
    TextField kode_barang, nama_barang, harga_jual, harga_jual_grosir, pajak_barang, satuan_barang;

    @FXML
    TextArea keterangan_barang;

    @FXML
    ChoiceBox kategori_pilihan;

    BarangModel produkModel = new BarangModel();

    public String toKodeKategori(String KodeNama) {
        String[] kode = KodeNama.split("-");

        return kode[0].trim();
    }

    @FXML
    public void tambahkan_action(ActionEvent event) {
//        System.out.println();
        try {
            System.out.println("berhasil");

            if (produkModel.insertProdukData(kode_barang.getText() + "", nama_barang.getText() + "", toKodeKategori(kategori_pilihan.getValue().toString()) + "", harga_jual.getText() + "", harga_jual_grosir.getText() + "", satuan_barang.getText() + "", pajak_barang.getText() + "", keterangan_barang.getText() + "")) {
                pesan.setText("Data berhasil ditambahkan");
                pesan.setTextFill(Color.GREEN);
            } else {
                pesan.setText("Data gagal ditambahkan");
                pesan.setTextFill(Color.RED);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdukCreateController.class.getName()).log(Level.SEVERE, null, ex);
            pesan.setText("Data gagal ditambahkan");
            pesan.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            produkModel.getKategori();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukCreateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        produkModel.kategoriObs.forEach((ko) -> {
            kategori_pilihan.getItems().add(ko.getKode_kategori() + " - " + ko.getNama_kategori());
        });

        kode_barang.setText("");
        nama_barang.setText("");
        kategori_pilihan.setValue("0 - undefined");
        harga_jual.setText("0");
        harga_jual_grosir.setText("0");
        pajak_barang.setText("0");
        satuan_barang.setText("");
        keterangan_barang.setText("");
    }
}
