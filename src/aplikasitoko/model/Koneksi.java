package aplikasitoko.model;

import java.sql.*;

public class Koneksi {

    public static Connection Connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String dbURL = "jdbc:mysql://localhost:3306/db_aplikasi_toko";
            Connection conn = DriverManager.getConnection(dbURL, "root", "");
//            if (conn != null) {
//                System.out.println("Connected to the database");
//                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
//                System.out.println("Driver name: " + dm.getDriverName());
//                System.out.println("Driver version: " + dm.getDriverVersion());
//                System.out.println("Product name: " + dm.getDatabaseProductName());
//                System.out.println("Product version: " + dm.getDatabaseProductVersion());
//                conn.close();
//            }
            return conn;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static Connection ConnectorSQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:db_aplikasi_toko.sqlite";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                conn.close();
            }
            return conn;
        } catch (Exception ex) {
            return null;
        }
    }
//
//    public static void createTabelPengaturan() throws SQLException {
//        try (Connection c = ConnectorSQLite()) {
//            PreparedStatement preparedStatement = null;
//            String query = "CREATE TABLE `pengaturan` (\n"
//                    + "  `KEY1` varchar(50) DEFAULT NULL,\n"
//                    + "  `KETERANGAN` varchar(100) DEFAULT NULL\n"
//                    + ")";
//            try {
//                preparedStatement = c.prepareStatement(query);
//                preparedStatement.executeUpdate();
//                preparedStatement.close();
//            } catch (SQLException e) {
//
//            } finally {
//
//            }
//        }
//    }

//    public static void main(String[] args) throws SQLException {
//        createTabelPengaturan();
//    }
}
