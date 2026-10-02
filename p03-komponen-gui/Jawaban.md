# Jawaban Pertanyaan Refleksi - P03 Komponen GUI Swing dan FlatLaf

Nama : Ariefa Salsabilla Azzahra  
NPM : 2410010519

1. Top-level container itu jendela utama yang punya bingkai dan judul, contohnya `JFrame`. Intermediate container itu wadah untuk mengelompokkan komponen di dalam jendela, contohnya `JPanel`. Atomic component itu komponen yang langsung berinteraksi dengan pengguna, contohnya `JButton`. Gampangnya seperti rumah (jendela), ruangan (panel), dan perabot (komponen).

2. Kalau tidak pakai `buttonGroup` yang sama, `lakiRadio` dan `perempuanRadio` dianggap berdiri sendiri, jadi keduanya bisa terpilih bersamaan. Dengan `ButtonGroup`, hanya satu radio button dalam grup yang bisa terpilih. Di `initComponents()` hubungan ini terlihat dari baris `jenisKelaminGroup.add(lakiRadio);` dan `jenisKelaminGroup.add(perempuanRadio);`.

3. `JComboBox` dipilih kalau pilihannya banyak, misalnya lima kota tujuan, karena daftarnya tersembunyi dan hemat tempat. `JRadioButton` dipilih kalau pilihannya sedikit (sekitar 2 sampai 4), misalnya jenis kelamin atau kelas tiket, supaya semua opsi langsung kelihatan dan bisa dipilih dengan satu klik.

4. Isi `initComponents()` dibuat otomatis oleh NetBeans dari rancangan di tab Design (file `.form`). Setiap rancangan berubah, blok ini dibuat ulang, jadi kode yang diketik di dalamnya bisa hilang atau tertimpa. Kode tambahan harus ditulis di luar blok abu-abu, yaitu di konstruktor setelah `initComponents()`, di isi event handler (di antara `//GEN-FIRST` dan `//GEN-LAST`), di method bantu buatan sendiri, dan di method `main`.

5. Setiap komponen Swing mengambil tampilannya dari look and feel yang aktif saat komponen itu dibuat. Kalau `FlatLightLaf.setup()` dipanggil setelah form dibuat, komponennya sudah terlanjur memakai tampilan Metal, jadi tema FlatLaf tidak muncul sampai `FlatLaf.updateUI()` dipanggil. Makanya `setup()` ditaruh di `main`, sebelum `new FormTiketTravel()`.
