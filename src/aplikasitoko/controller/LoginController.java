/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.lib.Session;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author abdul
 */
public class LoginController extends BaseController {

    /**
     * Initializes the controller class.
     */
    @FXML
    Label pesan_koneksi, pesan_kasir, pesan_gudang;

    @FXML
    PasswordField password_gudang, password_kasir;

    @FXML
    public void login_gudang_action(ActionEvent event) throws SQLException, IOException {
        if (loginModel.isConnected()) {
            if (loginModel.login_gudang(password_gudang.getText())) {
                Session.sesi = "2";
                ((Node) event.getSource()).getScene().getWindow().hide();
                newWindow("Home.fxml", "Aplikasi Toko");
            } else {
                pesan_gudang.setText("Password Gudang salah!");
                pesan_gudang.setTextFill(Color.RED);
            }
        } else {
            pesan_gudang.setText("Koneksi database tidak terhubung.");
            pesan_gudang.setTextFill(Color.RED);
        }

    }

    @FXML
    public void login_kasir_action(ActionEvent event) throws SQLException, IOException {
        if (loginModel.isConnected()) {
            if (loginModel.login_kasir(password_kasir.getText())) {
                Session.sesi = "1";
                ((Node) event.getSource()).getScene().getWindow().hide();
                newWindow("Home.fxml", "Aplikasi Toko");
            } else {
                pesan_kasir.setText("Password Kasir salah!");
                pesan_kasir.setTextFill(Color.RED);
            }
        } else {
            pesan_kasir.setText("Koneksi database tidak terhubung.");
            pesan_kasir.setTextFill(Color.RED);
        }

    }

    public void tes_koneksi() throws SQLException {
        if (loginModel.isConnected()) {
            pesan_koneksi.setText("Koneksi database terhubung.");
            pesan_koneksi.setTextFill(Color.GREEN);
        } else {
            pesan_koneksi.setText("Koneksi database tidak terhubung.");
            pesan_koneksi.setTextFill(Color.RED);
        }
    }

    @FXML
    public void tes_koneksi_action(ActionEvent event) throws SQLException {
        tes_koneksi();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            tes_koneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        pesan_gudang.setText("");
        pesan_kasir.setText("");
    }

}
