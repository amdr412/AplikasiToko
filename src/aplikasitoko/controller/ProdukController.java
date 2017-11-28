/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.model.BarangModel;
import aplikasitoko.object.ProdukObject;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LabTIA-40
 */
public class ProdukController implements Initializable {

    @FXML
    TableColumn kode_barang, nama_barang, kategori, harga_jual, harga_jual_grosir, pajak_barang, satuan_barang, keterangan_barang;

    @FXML
    TableView tabel_produk;

    @FXML
    Button tambah_produk, hapus_produk, edit_produk;

    BarangModel produkModel = new BarangModel();

    public static String kode_barang_pub, nama_barang_pub;

    public void isiTabelProduk() {
        try {
            produkModel.getBarangData();
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        kode_barang.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("kode_barang"));
        nama_barang.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("nama_barang"));
        kategori.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("kategori"));
        harga_jual.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("harga_jual"));
        harga_jual_grosir.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("harga_jual_grosir"));
        pajak_barang.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("pajak_barang"));
        satuan_barang.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("satuan_barang"));
        keterangan_barang.setCellValueFactory(new PropertyValueFactory<ProdukObject, String>("keterangan_barang"));

        tabel_produk.setEditable(false);
        tabel_produk.setItems(produkModel.produkObs);
    }

    @FXML
    public void tambah_produk_action(ActionEvent event) throws IOException {
        System.out.println("tambah");
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/ProdukCreate.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Tambah Produk");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(tambah_produk.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void hapus_produk_action(ActionEvent event) throws IOException {
        ProdukObject produk = (ProdukObject) tabel_produk.getSelectionModel().getSelectedItem();
        if (produk == null) {

        } else {
            kode_barang_pub = produk.getKode_barang();
            nama_barang_pub = produk.getNama_barang();
            System.out.println("hapus");
            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/ProdukDelete.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Hapus Produk");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(hapus_produk.getScene().getWindow());
            stage.showAndWait();
        }
    }

    @FXML
    private void edit_produk_action(ActionEvent event) throws IOException {
        ProdukObject produk = (ProdukObject) tabel_produk.getSelectionModel().getSelectedItem();
        if (produk == null) {

        } else {
            kode_barang_pub = produk.getKode_barang();
            nama_barang_pub = produk.getNama_barang();
            System.out.println("edit");
            Stage stage;
            Parent root;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/ProdukUpdate.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Edit Produk");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(hapus_produk.getScene().getWindow());
            stage.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        isiTabelProduk();
        edit_produk.setDisable(true);
        hapus_produk.setDisable(true);

        tabel_produk.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                edit_produk.setDisable(false);
                hapus_produk.setDisable(false);
            }
        });
        
        kode_barang.setMaxWidth(200);
    }
}
