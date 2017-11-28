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

//    public static void main(String[] args) {
//        Connector();
//    }
}
