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
    private String keterangan_kategori;

    public KategoriObject(String kode_kategori, String nama_kategori, String keterangan_kategori) {
        this.kode_kategori = kode_kategori;
        this.nama_kategori = nama_kategori;
        this.keterangan_kategori = keterangan_kategori;
    }

    public String getKode_kategori() {
        return kode_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public String getKeterangan_kategori() {
        return keterangan_kategori;
    }
}
