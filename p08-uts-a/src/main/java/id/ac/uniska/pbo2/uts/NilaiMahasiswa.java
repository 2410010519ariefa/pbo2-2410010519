package id.ac.uniska.pbo2.uts;

import java.util.Locale;

/**
 * Data satu mahasiswa beserta perhitungan nilai akhir dan huruf mutu.
 */
public record NilaiMahasiswa(String npm, String nama, int tugas, int uts, int uas) {

    private static final Locale LOKAL = Locale.forLanguageTag("id-ID");

    /** Bobot dalam persen: 30 tugas, 30 UTS, 40 UAS. Hasilnya skala 0 sampai 10000. */
    private int total() {
        return tugas * 30 + uts * 30 + uas * 40;
    }

    public double nilaiAkhir() {
        return total() / 100.0;
    }

    public String hurufMutu() {
        int t = total();
        if (t >= 8000) {
            return "A";
        }
        if (t >= 7500) {
            return "B+";
        }
        if (t >= 7000) {
            return "B";
        }
        if (t >= 6500) {
            return "C+";
        }
        if (t >= 6000) {
            return "C";
        }
        if (t >= 4000) {
            return "D";
        }
        return "E";
    }

    /** Menampilkan angka dengan dua angka di belakang koma, misalnya 82,50. */
    public static String format(double nilai) {
        return String.format(LOKAL, "%.2f", nilai);
    }
}