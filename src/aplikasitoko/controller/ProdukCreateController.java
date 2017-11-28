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
        try {
            if (!ValidasiField.hasValue(kode_barang.getText())) {
                pesan.setText("Kode Barang Wajib Diisi!");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.hasValue(nama_barang.getText())) {
                pesan.setText("Nama Barang Wajib Diisi!");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.hasValue(harga_jual.getText())) {
                pesan.setText("Harga Jual Wajib Diisi!");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.isNumber(harga_jual.getText())) {
                pesan.setText("Harga Jual Harus Angka!");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.isNumber(harga_jual_grosir.getText())) {
                pesan.setText("Harga Jual Grosir Harus Angka! Biarkan 0 bila tidak diisi");
                pesan.setTextFill(Color.RED);
            } else if (!ValidasiField.isNumber(pajak_barang.getText())) {
                pesan.setText("Pajak Barang Harus Angka! Biarkan 0 bila tidak diisi");
                pesan.setTextFill(Color.RED);
            } else {
                if (produkModel.insertProdukData(kode_barang.getText() + "", nama_barang.getText() + "", toKodeKategori(kategori_pilihan.getValue().toString()) + "", harga_jual.getText() + "", harga_jual_grosir.getText() + "", satuan_barang.getText() + "", pajak_barang.getText() + "", keterangan_barang.getText() + "")) {
                    pesan.setText("Data berhasil ditambahkan");
                    pesan.setTextFill(Color.GREEN);
                } else {
                    pesan.setText("Data gagal ditambahkan");
                    pesan.setTextFill(Color.RED);
                }
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
        kategori_pilihan.setValue("0 - undefined");
        harga_jual_grosir.setText("0");
        pajak_barang.setText("0");
    }
}
