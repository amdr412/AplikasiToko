/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.model;

import aplikasitoko.object.KategoriObject;
import aplikasitoko.object.ProdukObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdul
 */
public class BarangModel {

    Connection koneksi;

    public final ObservableList<ProdukObject> produkObs = FXCollections.observableArrayList();
    public final ObservableList<KategoriObject> kategoriObs = FXCollections.observableArrayList();

    public void Connect() {
        koneksi = Koneksi.Connector();
        if (koneksi == null) {
            System.exit(0);
        }
    }

    public void Disconnect() throws SQLException {
        koneksi.close();
    }

    public String getNamaKategoribyKode(String kode_kategori) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select nama_kategori from kategori where kode_kategori = ?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, kode_kategori);
            resultSet = preparedStatement.executeQuery();
            String nama_kategori = null;
            while (resultSet.next()) {
                nama_kategori = resultSet.getString("nama_kategori");
            }
            return nama_kategori;
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
            resultSet.close();
        }
        Disconnect();
        return null;
//        System.out.println(kunciObs);
    }

    public void getKategori() throws SQLException {
        Connect();
        kategoriObs.clear();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * from kategori";
        try {
            preparedStatement = koneksi.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            String kode_kategori = null;
            String nama_kategori = null;
            while (resultSet.next()) {
                kode_kategori = resultSet.getString("kode_kategori");
                nama_kategori = resultSet.getString("nama_kategori");
                kategoriObs.add(new KategoriObject(kode_kategori, nama_kategori));
            }

        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
            resultSet.close();
        }

        Disconnect();
//        System.out.println(kunciObs);
    }

    public void getBarangData() throws SQLException {
        Connect();
        produkObs.clear();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * from barang";
        try {
            preparedStatement = koneksi.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String kode_barang = resultSet.getString("kode_barang");
                String nama_kunci = resultSet.getString("nama_barang");
                String kode_kategori = resultSet.getString("kode_kategori");
                String harga_jual = resultSet.getString("harga_jual");
                String harga_jual_grosir = resultSet.getString("harga_jual_grosir");
                String satuan_barang = resultSet.getString("satuan_barang");
                String pajak_barang = resultSet.getString("pajak_barang");
                String keterangan_barang = resultSet.getString("keterangan_barang");

                String kategori = getNamaKategoribyKode(kode_kategori);

                produkObs.add(new ProdukObject(kode_barang, nama_kunci, kategori, harga_jual, harga_jual_grosir, satuan_barang, pajak_barang, keterangan_barang));
            }
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
            resultSet.close();
        }
//        System.out.println(kunciObs);
        Disconnect();
    }

    public void getBarangDatabyKodeBarang(String kode) throws SQLException {
        Connect();
        produkObs.clear();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "select * from barang where kode_barang = ?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, kode);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String kode_barang = resultSet.getString("kode_barang");
                String nama_kunci = resultSet.getString("nama_barang");
                String kode_kategori = resultSet.getString("kode_kategori");
                String harga_jual = resultSet.getString("harga_jual");
                String harga_jual_grosir = resultSet.getString("harga_jual_grosir");
                String satuan_barang = resultSet.getString("satuan_barang");
                String pajak_barang = resultSet.getString("pajak_barang");
                String keterangan_barang = resultSet.getString("keterangan_barang");

                //String kategori = getNamaKategoribyKode(kode_kategori);

                produkObs.add(new ProdukObject(kode_barang, nama_kunci, kode_kategori, harga_jual, harga_jual_grosir, satuan_barang, pajak_barang, keterangan_barang));
            }
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
            resultSet.close();
        }
//        System.out.println(kunciObs);
        Disconnect();
    }

    public boolean insertProdukData(String kode_barang, String nama_barang, String kode_kategori, String harga_jual, String harga_jual_grosir, String satuan_barang, String pajak_barang, String keterangan_barang) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;

        String query = "INSERT INTO `barang`(`KODE_BARANG`, `NAMA_BARANG`, `KODE_KATEGORI`, `HARGA_JUAL`, `HARGA_JUAL_GROSIR`, `SATUAN_BARANG`, `PAJAK_BARANG`, `KETERANGAN_BARANG`) VALUES (?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, kode_barang);
            preparedStatement.setString(2, nama_barang);
            preparedStatement.setString(3, kode_kategori);
            preparedStatement.setString(4, harga_jual);
            preparedStatement.setString(5, harga_jual_grosir);
            preparedStatement.setString(6, satuan_barang);
            preparedStatement.setString(7, pajak_barang);
            preparedStatement.setString(8, keterangan_barang);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
//            resultSet.close();
        }
        Disconnect();
        return false;
    }

    public boolean updateProdukData(String kode_barang_old, String kode_barang, String nama_barang, String kode_kategori, String harga_jual, String harga_jual_grosir, String satuan_barang, String pajak_barang, String keterangan_barang) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;

        String query = "UPDATE `barang` SET `KODE_BARANG`=?,`NAMA_BARANG`=?,`KODE_KATEGORI`=?,`HARGA_JUAL`=?,`HARGA_JUAL_GROSIR`=?,`SATUAN_BARANG`=?,`PAJAK_BARANG`=?,`KETERANGAN_BARANG`=? WHERE kode_barang=?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, kode_barang);
            preparedStatement.setString(2, nama_barang);
            preparedStatement.setString(3, kode_kategori);
            preparedStatement.setString(4, harga_jual);
            preparedStatement.setString(5, harga_jual_grosir);
            preparedStatement.setString(6, satuan_barang);
            preparedStatement.setString(7, pajak_barang);
            preparedStatement.setString(8, keterangan_barang);
            preparedStatement.setString(9, kode_barang_old);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
//            resultSet.close();
        }
        Disconnect();
        return false;
    }

    public boolean deleteProdukData(String kode_barang) throws SQLException {
        Connect();
        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;

        String query = "DELETE FROM `barang` WHERE `KODE_BARANG` = ?";
        try {
            preparedStatement = koneksi.prepareStatement(query);
            preparedStatement.setString(1, kode_barang);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {

        } finally {
            preparedStatement.close();
//            resultSet.close();
        }
        Disconnect();
        return false;
    }
}
