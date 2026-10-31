package id.ac.uniska.pbo2.p07;

/**
 * Status buku. Nilai dari toString() dipakai sebagai teks di JComboBox dan tabel.
 */
public enum Status {
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}