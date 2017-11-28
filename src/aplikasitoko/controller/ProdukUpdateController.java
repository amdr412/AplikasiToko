/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.ValidasiField;
import aplikasitoko.model.BarangModel;
import aplikasitoko.object.KategoriObject;
import aplikasitoko.object.ProdukObject;
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
public class ProdukUpdateController implements Initializable {

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
    public void editkan_action(ActionEvent event) {
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
                if (produkModel.updateProdukData(ProdukController.kode_barang_pub, kode_barang.getText() + "", nama_barang.getText() + "", toKodeKategori(kategori_pilihan.getValue().toString()) + "", harga_jual.getText() + "", harga_jual_grosir.getText() + "", satuan_barang.getText() + "", pajak_barang.getText() + "", keterangan_barang.getText() + "")) {
                    pesan.setText("Data berhasil diperbarui");
                    pesan.setTextFill(Color.GREEN);
                } else {
                    pesan.setText("Data gagal diperbarui");
                    pesan.setTextFill(Color.RED);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdukUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            pesan.setText("Data gagal diperbarui");
            pesan.setTextFill(Color.RED);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            produkModel.getKategori();
            produkModel.getBarangDatabyKodeBarang(ProdukController.kode_barang_pub);
        } catch (SQLException ex) {
            Logger.getLogger(ProdukUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }

        produkModel.kategoriObs.forEach((ko) -> {
            kategori_pilihan.getItems().add(ko.getKode_kategori() + " - " + ko.getNama_kategori());
        });
        ProdukObject produk = produkModel.produkObs.get(0);
        kode_barang.setText(produk.getKode_barang());
        nama_barang.setText(produk.getNama_barang());
        try {
            kategori_pilihan.setValue(produk.getKategori() + " - " + produkModel.getNamaKategoribyKode(produk.getKategori()));
        } catch (SQLException ex) {
            Logger.getLogger(ProdukUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        harga_jual.setText(produk.getHarga_jual());
        harga_jual_grosir.setText(produk.getHarga_jual_grosir());
        pajak_barang.setText(produk.getPajak_barang());
        satuan_barang.setText(produk.getSatuan_barang());
        keterangan_barang.setText(produk.getKeterangan_barang());

    }
}
