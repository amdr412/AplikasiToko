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
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btn_beranda, btn_barang, btn_customer, btn_supplier, btn_kasir, btn_pengaturan;

    @FXML
    private Pane view;

    private void resetAllStyle() {
        btnSetDefaultStyle(btn_beranda);
        btnSetDefaultStyle(btn_barang);
        btnSetDefaultStyle(btn_customer);
        btnSetDefaultStyle(btn_supplier);
        btnSetDefaultStyle(btn_kasir);
        btnSetDefaultStyle(btn_pengaturan);
    }

    private void btnSetDefaultStyle(Button btn) {
        btn.fontProperty().setValue(Font.font("System", 22));
        btn.setStyle("-fx-background-color:  #2677d3;");
    }

    private void btnSetSelected(Button btn) {
        btn.fontProperty().setValue(Font.font("System", FontWeight.BOLD, 22));
        btn.setStyle("-fx-background-color:  #1c67bc;");
    }

    private void setView(Pane pane, String url) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + url));
        pane.getChildren().clear();
        pane.getChildren().add(newLoadedPane);
    }

    @FXML
    private void btn_beranda_action(ActionEvent event) throws IOException {
        System.out.println("Beranda clicked me!");
        resetAllStyle();
        btnSetSelected(btn_beranda);
        setView(view, "Beranda.fxml");
    }

    @FXML
    private void btn_barang_action(ActionEvent event) throws IOException {
        System.out.println("Barang clicked me!");
        resetAllStyle();
        btnSetSelected(btn_barang);
        setView(view, "Barang.fxml");
    }

    @FXML
    private void btn_customer_action(ActionEvent event) {
        System.out.println("Customer clicked me!");
        resetAllStyle();
        btnSetSelected(btn_customer);
    }

    @FXML
    private void btn_supplier_action(ActionEvent event) {
        System.out.println("Supplier clicked me!");
        resetAllStyle();
        btnSetSelected(btn_supplier);
    }

    @FXML
    private void btn_kasir_action(ActionEvent event) {
        System.out.println("Kasir clicked me!");
        resetAllStyle();
        btnSetSelected(btn_kasir);
    }

    @FXML
    private void btn_pengaturan_action(ActionEvent event) {
        System.out.println("Pengaturan clicked me!");
        resetAllStyle();
        btnSetSelected(btn_pengaturan);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            setView(view, "Beranda.fxml");
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
