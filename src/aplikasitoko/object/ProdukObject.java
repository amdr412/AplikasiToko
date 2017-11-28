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
public class ProdukObject {
    private String kode_barang;
    private String nama_barang;
    private String kategori;
    private String harga_jual;
    private String harga_jual_grosir;
    private String satuan_barang;
    private String pajak_barang;
    private String keterangan_barang;

    public ProdukObject(String kode_barang, String nama_barang, String kategori, String harga_jual, String harga_jual_grosir, String satuan_barang, String pajak_barang, String keterangan_barang) {
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.kategori = kategori;
        this.harga_jual = harga_jual;
        this.harga_jual_grosir = harga_jual_grosir;
        this.satuan_barang = satuan_barang;
        this.pajak_barang = pajak_barang;
        this.keterangan_barang = keterangan_barang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getKategori() {
        return kategori;
    }

    public String getHarga_jual() {
        return harga_jual;
    }

    public String getHarga_jual_grosir() {
        return harga_jual_grosir;
    }

    public String getSatuan_barang() {
        return satuan_barang;
    }

    public String getPajak_barang() {
        return pajak_barang;
    }

    public String getKeterangan_barang() {
        return keterangan_barang;
    }
    
    
}
