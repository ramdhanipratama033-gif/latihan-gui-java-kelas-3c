import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class latihan_gui extends JFrame implements ActionListener {

    private JTextField txtJudul, txtIsi;
    private JButton btnTambah, btnHapus;
    private DefaultListModel<String> modelJudul;
    private JList<String> listNovel;
    private JTextArea areaBaca;
    private JLabel lblStatus;
    private ArrayList<String> daftarIsi = new ArrayList<>();

    public latihan_gui() {

        setTitle("NoveLoka - Kelola & Baca Novel");
        setSize(620, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel panelInput = new JPanel(new GridLayout(2, 2, 8, 8));
        panelInput.setBorder(BorderFactory.createTitledBorder("Tambah Novel Baru"));

        txtJudul = new JTextField();
        txtIsi = new JTextField();
        panelInput.add(new JLabel("Judul Novel:"));
        panelInput.add(txtJudul);
        panelInput.add(new JLabel("Isi / Sinopsis Cerita:"));
        panelInput.add(txtIsi);

        modelJudul = new DefaultListModel<>();
        listNovel = new JList<>(modelJudul);
        listNovel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollList = new JScrollPane(listNovel);
        scrollList.setBorder(BorderFactory.createTitledBorder("Daftar Novel"));

        areaBaca = new JTextArea();
        areaBaca.setEditable(false);
        areaBaca.setLineWrap(true);
        areaBaca.setWrapStyleWord(true);
        areaBaca.setFont(new Font("Serif", Font.PLAIN, 14));
        areaBaca.setMargin(new Insets(8, 10, 8, 10));
        JScrollPane scrollBaca = new JScrollPane(areaBaca);
        scrollBaca.setBorder(BorderFactory.createTitledBorder("Area Baca Novel"));

        JPanel panelTengah = new JPanel(new GridLayout(1, 2, 10, 0));
        panelTengah.add(scrollList);
        panelTengah.add(scrollBaca);

        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        btnTambah = new JButton("Tambah Novel");
        btnHapus = new JButton("Hapus Novel");
        panelTombol.add(btnTambah);
        panelTombol.add(btnHapus);

        lblStatus = new JLabel("Status: Klik judul di daftar untuk membaca.", SwingConstants.CENTER);

        JPanel panelBawah = new JPanel(new BorderLayout(5, 5));
        panelBawah.add(panelTombol, BorderLayout.CENTER);
        panelBawah.add(lblStatus, BorderLayout.SOUTH);

        add(panelInput, BorderLayout.NORTH);
        add(panelTengah, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        tambahData("Pedang Bayangan", "Angin dingin berembus melewati gerbang kota tua Valoria saat Arka memulai perjalanannya.");
        tambahData("Catatan Senja", "Raka naik ke atap sekolah seperti biasa, namun bangku favoritnya sudah ditempati seseorang.");

        btnTambah.addActionListener(this);
        btnHapus.addActionListener(this);

        listNovel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int idx = listNovel.getSelectedIndex();
                if (idx != -1) {
                    areaBaca.setText(modelJudul.get(idx) + "\n\n" + daftarIsi.get(idx));
                    lblStatus.setText("Status: Membaca \"" + modelJudul.get(idx) + "\"");
                }
            }
        });
    }

    private void tambahData(String judul, String isi) {
        modelJudul.addElement(judul);
        daftarIsi.add(isi);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            String judul = txtJudul.getText().trim();
            String isi = txtIsi.getText().trim();

            if (judul.isEmpty() || isi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Judul dan isi novel wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            tambahData(judul, isi);
            txtJudul.setText("");
            txtIsi.setText("");
            lblStatus.setText("Status: Novel \"" + judul + "\" berhasil ditambahkan.");

        } else if (e.getSource() == btnHapus) {
            int idx = listNovel.getSelectedIndex();
            if (idx == -1) {
                JOptionPane.showMessageDialog(this, "Pilih novel yang ingin dihapus dari daftar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String terhapus = modelJudul.remove(idx);
            daftarIsi.remove(idx);
            areaBaca.setText("");
            lblStatus.setText("Status: Novel \"" + terhapus + "\" telah dihapus.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new latihan_gui().setVisible(true));
    }
}