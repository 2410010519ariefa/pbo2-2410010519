//Nama : Ariefa Salsabilla Azzahra
//NPM : 2410010519

package id.ac.uniska.pbo2.uts;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class NilaiTableModel extends AbstractTableModel {

    private static final String[] KOLOM = {"NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"};

    private final List<NilaiMahasiswa> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Class<?> getColumnClass(int kolom) {
        return (kolom >= 2 && kolom <= 4) ? Integer.class : String.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        NilaiMahasiswa n = daftar.get(baris);
        return switch (kolom) {
            case 0 -> n.npm();
            case 1 -> n.nama();
            case 2 -> n.tugas();
            case 3 -> n.uts();
            case 4 -> n.uas();
            case 5 -> NilaiMahasiswa.format(n.nilaiAkhir());
            default -> n.hurufMutu();
        };
    }

    public void tambah(NilaiMahasiswa nilai) {
        daftar.add(nilai);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public boolean adaNpm(String npm) {
        for (NilaiMahasiswa n : daftar) {
            if (n.npm().equals(npm)) {
                return true;
            }
        }
        return false;
    }

    public double rataRataAkhir() {
        if (daftar.isEmpty()) {
            return 0;
        }
        double jumlah = 0;
        for (NilaiMahasiswa n : daftar) {
            jumlah += n.nilaiAkhir();
        }
        return jumlah / daftar.size();
    }
}