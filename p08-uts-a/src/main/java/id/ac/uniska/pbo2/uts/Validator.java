package id.ac.uniska.pbo2.uts;

/**
 * Aturan validasi isian form tanpa GUI.
 * Setiap method mengembalikan pesan kesalahan, atau null jika nilai sudah benar.
 */
public final class Validator {

    private Validator() {
        // kelas utilitas, tidak perlu dibuat object-nya
    }

    public static String npm(String npm) {
        if (npm == null || !npm.trim().matches("\\d{10}")) {
            return "NPM harus 10 digit angka";
        }
        return null;
    }

    public static String nama(String nama) {
        if (nama == null || nama.isBlank()) {
            return "Nama wajib diisi";
        }
        return null;
    }

    /** Memeriksa bilangan bulat 0 sampai 100. Contoh label: Nilai UTS. */
    public static String nilai(String teks, String label) {
        String pesan = label + " harus angka bulat 0 sampai 100";
        if (teks == null || !teks.trim().matches("\\d{1,3}")) {
            return pesan;
        }
        int angka = Integer.parseInt(teks.trim());
        if (angka > 100) {
            return pesan;
        }
        return null;
    }
}