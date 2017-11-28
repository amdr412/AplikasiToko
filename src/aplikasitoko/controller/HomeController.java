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

import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private boolean panel_kiri = true;

    @FXML
    private Pane tab_kiri;

    @FXML
    private BorderPane center;

    @FXML
    private BorderPane home_pane;

    @FXML
    private Button btn_barang, btn_customer, btn_supplier, btn_kasir, btn_laporan, btn_pengaturan;

    private void btnSetDefaultStyle(Button btn) {
        btn.textFillProperty().setValue(Color.BLACK);
        btn.setStyle("-fx-background-color: transparent;");
    }

    private void btnSetSelected(Button btn) {
        btn.textFillProperty().setValue(Color.WHITE);
        btn.setStyle("-fx-background-color: #39ace5;");
    }

    private void resetAllStyle() {
        btnSetDefaultStyle(btn_barang);
        btnSetDefaultStyle(btn_customer);
        btnSetDefaultStyle(btn_supplier);
        btnSetDefaultStyle(btn_kasir);
        btnSetDefaultStyle(btn_laporan);
        btnSetDefaultStyle(btn_pengaturan);
    }

    private void setView(Pane pane, String url) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + url));
        pane.getChildren().clear();
        pane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void menu_clicked(MouseEvent event) {
        if (panel_kiri) {
            home_pane.setLeft(tab_kiri);
            panel_kiri = false;
        } else {
            home_pane.setLeft(null);
            panel_kiri = true;
        }
    }

    @FXML
    private void btn_barang_action(ActionEvent event) throws IOException {
        setView(center, "Barang.fxml");
        resetAllStyle();
        btnSetSelected(btn_barang);
    }

    @FXML
    private void btn_customer_action(ActionEvent event) throws IOException {
        setView(center, "Customer.fxml");
        resetAllStyle();
        btnSetSelected(btn_customer);
    }

    @FXML
    private void btn_supplier_action(ActionEvent event) throws IOException {
        setView(center, "Supplier.fxml");
        resetAllStyle();
        btnSetSelected(btn_supplier);
    }

    @FXML
    private void btn_kasir_action(ActionEvent event) throws IOException {
        setView(center, "Kasir.fxml");
        resetAllStyle();
        btnSetSelected(btn_kasir);
    }

    @FXML
    private void btn_laporan_action(ActionEvent event) throws IOException {
        setView(center, "Laporan.fxml");
        resetAllStyle();
        btnSetSelected(btn_laporan);
    }

    @FXML
    private void btn_pengaturan_action(ActionEvent event) throws IOException {
        setView(center, "Pengaturan_2.fxml");
        resetAllStyle();
        btnSetSelected(btn_pengaturan);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        home_pane.setLeft(null);
        try {
            // TODO
            setView(center, "Barang.fxml");
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
