/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author abdul
 */
public class LoginModel {

    Connection koneksi;

    public void Connect() {
        koneksi = Koneksi.Connector();
    }

    public void Disconnect() throws SQLException {
        koneksi.close();
    }

    public boolean isConnected() throws SQLException {
        try {
            Connect();

            if (koneksi != null) {
                Disconnect();
                return true;
            }
        } catch (SQLException e) {
        }

        return false;
    }

    public boolean login_kasir(String password_kasir) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * from pengaturan where key1 = ? and keterangan = ?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, "password_kasir");
            preparedStatement.setString(2, password_kasir);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        Disconnect();
        return false;
//        System.out.println(kunciObs);
    }

    public boolean login_gudang(String password_gudang) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * from pengaturan where key1 = ? and keterangan = ?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, "password_gudang");
            preparedStatement.setString(2, password_gudang);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        Disconnect();
        return false;
//        System.out.println(kunciObs);
    }
}
