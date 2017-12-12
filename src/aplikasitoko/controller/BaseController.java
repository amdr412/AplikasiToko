/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.controller;

import aplikasitoko.model.BarangModel;
import aplikasitoko.model.CustomerModel;
import aplikasitoko.model.LoginModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author LabTIA-40
 */
public class BaseController implements Initializable {

    public BarangModel barangModel = new BarangModel();

    public CustomerModel customerModel = new CustomerModel();

    public LoginModel loginModel = new LoginModel();

    public void modalPopUp(String fxml, String title, Window windowOwner) throws IOException {
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + fxml));
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(windowOwner);
        stage.showAndWait();
    }

    public void newWindow(String fxml, String title) throws IOException {
        Stage stage;
        Parent root;
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + fxml));
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
    }

    public void setView(Pane pane, String fxml) throws IOException {
        Pane newLoadedPane = FXMLLoader.load(getClass().getResource("/aplikasitoko/view/" + fxml));
        pane.getChildren().clear();
        pane.getChildren().add(newLoadedPane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
