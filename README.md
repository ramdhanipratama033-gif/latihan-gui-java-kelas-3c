# Latihan GUI Java - NoveLoka (Kelola & Baca Novel)

Repositori ini berisi hasil latihan/eksplorasi **Graphical User Interface (GUI)** pada Java menggunakan pustaka **Swing** dan **AWT** dengan fitur menambah, membaca, dan menghapus daftar novel.

## 5 Komponen Utama GUI yang Digunakan

1. **Kelas Kontainer Tingkat Atas (Top-Level Container)**
   * **`JFrame`**: Jendela utama aplikasi yang menampung seluruh panel input, daftar novel, area baca, dan tombol aksi.

2. **Kelas Kontainer Menengah (Intermediate Container)**
   * **`JPanel`**: Mengelompokkan elemen antarmuka menjadi bagian terpisah (`panelInput`, `panelTengah`, `panelTombol`, dan `panelBawah`).
   * **`JScrollPane`**: Membungkus `JList` dan `JTextArea` agar daftar novel dan isi cerita dapat digulir (*scroll*).

3. **Kelas Komponen Atom (Atomic Components)**
   * **`JLabel`**: Menampilkan label keterangan input dan teks status di bagian bawah jendela.
   * **`JTextField`**: Kolom input untuk mengetikkan judul dan isi/sinopsis novel baru.
   * **`JButton`**: Tombol **Tambah Novel** dan **Hapus Novel**.
   * **`JList`**: Menampilkan daftar judul novel yang tersedia dan dapat dipilih.
   * **`JTextArea`**: Menampilkan isi cerita dari novel yang diklik pada daftar.

4. **Kelas Tata Letak (Layout Manager)**
   * **`BorderLayout`**: Mengatur pembagian posisi utama pada `JFrame` (`NORTH`, `CENTER`, `SOUTH`) dan `panelBawah`.
   * **`GridLayout`**: Menyusun form input dalam 2 baris 2 kolom (`panelInput`) serta membagi area daftar dan area baca berdampingan (`panelTengah`).
   * **`FlowLayout`**: Menyejajarkan tombol **Tambah Novel** dan **Hapus Novel** di bagian tengah (`panelTombol`).

5. **Pendengar Peristiwa (Event Listener & Event Adapter)**
   * **Antarmuka `ActionListener`**: Mengganti (*override*) metode `actionPerformed(ActionEvent e)` untuk memproses aksi tombol tambah novel dan hapus novel.
   * **Kelas Adaptor `MouseAdapter`**: Mengganti metode `mouseClicked(MouseEvent e)` pada `JList` agar klik pada judul novel langsung menampilkan isi ceritanya di `JTextArea`.

## Tangkapan Layar
![Tampilan 1](Screenshot%202026-11-24%20063847.png)

![Tampilan 2](Screenshot%202026-11-24%20063929.png)

![Tampilan 3](Screenshot%202026-11-24%20063939.png)

![Tampilan 4](Screenshot%202026-11-24%20063947.png)