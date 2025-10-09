package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class PhieuMuon extends JPanel {
    private JTextField txtMaPhieu, txtDocGia, txtNhanVien, txtTrangThai;
    private JSpinner dateMuon, dateTra;
    private JTable tblPhieuMuon;
    private DefaultTableModel model;

    public PhieuMuon() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.white);

        // --- Tiêu đề ---
        JLabel titleLabel = new JLabel("Quản Lý Phiếu Mượn", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(40, 40, 80));
        add(titleLabel, BorderLayout.NORTH);

        // --- Panel nhập liệu ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Thông tin phiếu mượn"));
        inputPanel.setBackground(Color.white);

        inputPanel.add(new JLabel("Mã Phiếu:"));
        txtMaPhieu = new JTextField();
        inputPanel.add(txtMaPhieu);

        inputPanel.add(new JLabel("Ngày Mượn:"));
        dateMuon = new JSpinner(new SpinnerDateModel());
        dateMuon.setEditor(new JSpinner.DateEditor(dateMuon, "dd/MM/yyyy"));
        inputPanel.add(dateMuon);

        inputPanel.add(new JLabel("Ngày Trả:"));
        dateTra = new JSpinner(new SpinnerDateModel());
        dateTra.setEditor(new JSpinner.DateEditor(dateTra, "dd/MM/yyyy"));
        inputPanel.add(dateTra);

        inputPanel.add(new JLabel("Mã Độc Giả:"));
        txtDocGia = new JTextField();
        inputPanel.add(txtDocGia);

        inputPanel.add(new JLabel("Mã Nhân Viên:"));
        txtNhanVien = new JTextField();
        inputPanel.add(txtNhanVien);

        inputPanel.add(new JLabel("Trạng Thái:"));
        txtTrangThai = new JTextField();
        inputPanel.add(txtTrangThai);

        add(inputPanel, BorderLayout.NORTH);

        // --- Bảng hiển thị danh sách phiếu mượn ---
        String[] columns = {"Mã Phiếu", "Ngày Mượn", "Ngày Trả", "Mã Độc Giả", "Mã Nhân Viên", "Trạng Thái"};
        model = new DefaultTableModel(columns, 0);
        tblPhieuMuon = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tblPhieuMuon);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Danh sách phiếu mượn"));
        add(scrollPane, BorderLayout.CENTER);

        // --- Nút chức năng ---
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.white);
        JButton btnThem = new JButton("Thêm");
        JButton btnSua = new JButton("Sửa");
        JButton btnXoa = new JButton("Xóa");
        JButton btnLamMoi = new JButton("Làm Mới");
        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnLamMoi);
        add(buttonPanel, BorderLayout.SOUTH);

        // --- Sự kiện nút ---
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{
                        txtMaPhieu.getText(),
                        ((JSpinner.DateEditor) dateMuon.getEditor()).getFormat().format(dateMuon.getValue()),
                        ((JSpinner.DateEditor) dateTra.getEditor()).getFormat().format(dateTra.getValue()),
                        txtDocGia.getText(),
                        txtNhanVien.getText(),
                        txtTrangThai.getText()
                });
            }
        });

        btnLamMoi.addActionListener(e -> clearFields());
        btnXoa.addActionListener(e -> deleteRow());
    }

    private void clearFields() {
        txtMaPhieu.setText("");
        txtDocGia.setText("");
        txtNhanVien.setText("");
        txtTrangThai.setText("");
        dateMuon.setValue(new java.util.Date());
        dateTra.setValue(new java.util.Date());
    }

    private void deleteRow() {
        int row = tblPhieuMuon.getSelectedRow();
        if (row != -1) {
            ((DefaultTableModel) tblPhieuMuon.getModel()).removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa!");
        }
    }
}
