/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LabTIA-40
 */
public class KategoriController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button tambah_kategori, edit_kategori;
    
    @FXML
    private void tambah_kategori_action(ActionEvent event) throws IOException {
        System.out.println("Tambah Kategori clicked me!");
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/TambahKategori.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Tambah Kategori");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(tambah_kategori.getScene().getWindow());
        stage.showAndWait();
    }
    @FXML
    private void edit_kategori_action(ActionEvent event) throws IOException {
        System.out.println("Edit Kategori clicked me!");
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/TambahKategori.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Edit Kategori");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(tambah_kategori.getScene().getWindow());
        stage.showAndWait();
    }
    @FXML
    private void hapus_kategori_action(ActionEvent event) throws IOException {
        System.out.println("Edit Kategori clicked me!");
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/PromptHapusData.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Hapus Kategori");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(tambah_kategori.getScene().getWindow());
        stage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
