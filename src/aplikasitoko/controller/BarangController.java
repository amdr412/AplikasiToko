/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author LabTIA-40
 */
public class BarangController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button btn_sub_kategori, btn_sub_produk, btn_sub_masuk, btn_sub_keluar;

    @FXML
    private Pane barang_view;

    private void resetAllStyle() {
        btnSetDefaultStyle(btn_sub_kategori);
        btnSetDefaultStyle(btn_sub_produk);
        btnSetDefaultStyle(btn_sub_masuk);
        btnSetDefaultStyle(btn_sub_keluar);
    }

    private void btnSetDefaultStyle(Button btn) {
        btn.fontProperty().setValue(Font.font("System", 20));
        btn.setStyle("-fx-background-color:  transparent;");
    }

    private void btnSetSelected(Button btn) {
        btn.fontProperty().setValue(Font.font("System", 20));
        btn.setStyle("-fx-background-color:  #1c67bc;");
    }

    private void setView(Pane pane, String url) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + url));
        pane.getChildren().clear();
        pane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void btn_sub_kategori_action(ActionEvent event) throws IOException {
        System.out.println("Kategori clicked me!");
        resetAllStyle();
        btnSetSelected(btn_sub_kategori);
        setView(barang_view, "Kategori.fxml");
    }

    @FXML
    private void btn_sub_produk_action(ActionEvent event) throws IOException {
        System.out.println("Produk clicked me!");
        resetAllStyle();
        btnSetSelected(btn_sub_produk);
        setView(barang_view, "Produk.fxml");
    }

    @FXML
    private void btn_sub_masuk_action(ActionEvent event) throws IOException {
        System.out.println("Masuk clicked me!");
        resetAllStyle();
        btnSetSelected(btn_sub_masuk);
        setView(barang_view, "Masuk.fxml");
    }

    @FXML
    private void btn_sub_keluar_action(ActionEvent event) throws IOException {
        System.out.println("Keluar clicked me!");
        resetAllStyle();
        btnSetSelected(btn_sub_keluar);
        setView(barang_view, "Keluar.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            setView(barang_view, "Kategori.fxml");
        } catch (IOException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
