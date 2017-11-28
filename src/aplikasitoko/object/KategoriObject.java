/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasitoko.object;

/**
 *
 * @author abdul
 */
public class KategoriObject {

    private String kode_kategori;
    private String nama_kategori;

    public KategoriObject(String kode_kategori, String nama_kategori) {
        this.kode_kategori = kode_kategori;
        this.nama_kategori = nama_kategori;
    }

    public String getKode_kategori() {
        return kode_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

}
