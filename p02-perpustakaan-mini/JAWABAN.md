Jawaban Eksperimen Praktikum 6 - P02 Perpustakaan Mini

Nama	: Ariefa Salsabilla Azzahra

NPM	: 2410010519



1\. Error "Koleksi is abstract; cannot be instantiated", karena Koleksi adalah abstract class sehingga tidak boleh dibuat objeknya langsung dengan new.



2\. Dengan @Override, error "method does not override or implement a method from a supertype" karena nama method tidak cocok dengan induknya. Tanpa @Override, tetap error "Buku is not abstract and does not override abstract method hitungDenda(int)" karena hitungdenda dianggap method baru dan kontrak BisaDipinjam belum diimplementasikan.



3\. Program berhenti dengan IllegalArgumentException "Judul tidak boleh kosong" karena konstruktor Koleksi memvalidasi judul dengan isBlank().



4\. Aturan enkapsulasi dilanggar: status seharusnya hanya berubah lewat pinjam() dan kembalikan(). Jika dibuat public, status bisa diubah langsung sehingga B002 yang masih dipinjam bisa dipinjam lagi dan datanya tidak konsisten.

