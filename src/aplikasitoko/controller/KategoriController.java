/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.object.KategoriObject;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author LabTIA-40
 */
public class KategoriController extends BaseController {

    /**
     * Initializes the controller class.
     */
    public static String kode_kategori_pub, nama_kategori_pub;

    @FXML
    Button tambah_kategori, edit_kategori, hapus_kategori;

    @FXML
    TableView tabel_kategori;

    @FXML
    TableColumn kode_kategori, nama_kategori, keterangan_kategori;

    @FXML
    private void tambah_kategori_action(ActionEvent event) throws IOException {
        modalPopUp("KategoriCreate.fxml", "Tambah Kategori", tambah_kategori.getScene().getWindow());
        isiTabelKategori();
    }

    @FXML
    private void edit_kategori_action(ActionEvent event) throws IOException {
        KategoriObject kategori = (KategoriObject) tabel_kategori.getSelectionModel().getSelectedItem();
        if (kategori == null) {

        } else {
            kode_kategori_pub = kategori.getKode_kategori();
            nama_kategori_pub = kategori.getNama_kategori();
            modalPopUp("KategoriUpdate.fxml", "Edit Kategori", edit_kategori.getScene().getWindow());
            isiTabelKategori();
        }
    }

    @FXML
    private void hapus_kategori_action(ActionEvent event) throws IOException {
        KategoriObject kategori = (KategoriObject) tabel_kategori.getSelectionModel().getSelectedItem();
        if (kategori == null) {

        } else {
            kode_kategori_pub = kategori.getKode_kategori();
            nama_kategori_pub = kategori.getNama_kategori();
            modalPopUp("KategoriDelete.fxml", "Hapus Kategori", hapus_kategori.getScene().getWindow());
            isiTabelKategori();
        }
    }

    public void isiTabelKategori() {
        try {
            barangModel.getKategori();
        } catch (SQLException ex) {
            Logger.getLogger(KategoriController.class.getName()).log(Level.SEVERE, null, ex);
        }

        kode_kategori.setCellValueFactory(new PropertyValueFactory<KategoriObject, String>("kode_kategori"));
        nama_kategori.setCellValueFactory(new PropertyValueFactory<KategoriObject, String>("nama_kategori"));
        keterangan_kategori.setCellValueFactory(new PropertyValueFactory<KategoriObject, String>("keterangan_kategori"));

        tabel_kategori.setEditable(false);
        tabel_kategori.setItems(barangModel.kategoriObs);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        isiTabelKategori();

        edit_kategori.setDisable(true);
        hapus_kategori.setDisable(true);

        tabel_kategori.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                edit_kategori.setDisable(false);
                hapus_kategori.setDisable(false);
            }
        });
    }

}
