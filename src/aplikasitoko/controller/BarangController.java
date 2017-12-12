/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.model.BarangModel;
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
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author LabTIA-40
 */
public class BarangController extends BaseController {

    /**
     * Initializes the controller class.
     */
    @FXML
    public BorderPane barang_view;

    @FXML
    public Button btn_produk, btn_kategori, btn_masuk, btn_keluar;

    @FXML
    public Pane view_barang;

    private void btnSetDefaultStyle(Button btn) {
        btn.textFillProperty().setValue(Color.BLACK);
        btn.setStyle("-fx-background-color: transparent;");
    }

    private void btnSetSelected(Button btn) {
        btn.textFillProperty().setValue(Color.WHITE);
        btn.setStyle("-fx-background-color: #3098cc;");
    }

    private void resetAllStyle() {
        btnSetDefaultStyle(btn_produk);
        btnSetDefaultStyle(btn_kategori);
        btnSetDefaultStyle(btn_masuk);
        btnSetDefaultStyle(btn_keluar);
    }

    @FXML
    private void btn_produk_action(ActionEvent event) throws IOException {
        setView(view_barang, "Produk.fxml");
        resetAllStyle();
        btnSetSelected(btn_produk);
    }

    @FXML
    private void btn_kategori_action(ActionEvent event) throws IOException {
        setView(view_barang, "Kategori.fxml");
        resetAllStyle();
        btnSetSelected(btn_kategori);
    }

    @FXML
    private void btn_masuk_action(ActionEvent event) throws IOException {
        setView(view_barang, "Masuk.fxml");
        resetAllStyle();
        btnSetSelected(btn_masuk);
    }

    @FXML
    private void btn_keluar_action(ActionEvent event) throws IOException {
        setView(view_barang, "Keluar.fxml");
        resetAllStyle();
        btnSetSelected(btn_keluar);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setView(view_barang, "Produk.fxml");
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
