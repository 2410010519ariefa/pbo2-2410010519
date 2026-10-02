/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ac.uniska.pbo2.p02;

/**
 * Kontak untuk semua koleksi yang dapat dipinjam.
 * Bersifat abstract karena setiap koleksi pasti berjenis tertentu, misalnya Buku atau Majalah.
 */
public interface BisaDipinjam {
    
    /** Lama peminjaman maksimal dalam hari. */
    int batasHariPinjam();
    
    /** Denda keterlambatan dalam rupiah. */
    long hitungDenda(int hariTerlambat);
}