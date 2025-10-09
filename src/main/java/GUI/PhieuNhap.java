package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PhieuNhap extends  JPanel {
    JPanel PhieuNhapForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable PhieuNhapTable;
    JPanel searchBar = new JPanel();

    // === Các trường nhập liệu ===
    JTextField maPhieuField = new JTextField();
    JTextField ngayNhapField = new JTextField();
    JTextField nhaCungCapField = new JTextField();
    JTextField nhanVienField = new JTextField();
    JTextField tongTienField = new JTextField();

    JTextField searchField = new JTextField();

    // === Các nút chức năng ===
    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    // === Các nhãn ===
    JLabel maPhieuLabel = new JLabel("Mã phiếu nhập:");
    JLabel ngayNhapLabel = new JLabel("Ngày nhập:");
    JLabel nhaCungCapLabel = new JLabel("Nhà cung cấp:");
    JLabel nhanVienLabel = new JLabel("Nhân viên nhập:");
    JLabel tongTienLabel = new JLabel("Tổng tiền:");
    JLabel searchLabel = new JLabel("Tìm kiếm:");

    public PhieuNhap() {
        initGUI();
    }

    private void initGUI() {
        setStyle();

        // === Dữ liệu mẫu cho bảng ===
        String[] columnNames = {"Mã phiếu", "Ngày nhập", "Nhà cung cấp", "Nhân viên", "Tổng tiền"};
        Object[][] data = {
                {"PN001", "09/10/2025", "NXB Kim Đồng", "Nguyễn Văn A", "2.500.000"},
                {"PN002", "10/10/2025", "Fahasa", "Trần Thị B", "4.000.000"}
        };
        PhieuNhapTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(PhieuNhapTable);

        // === Layout cho form nhập liệu ===
        GroupLayout formLayout = new GroupLayout(PhieuNhapForm);
        PhieuNhapForm.setLayout(formLayout);

        formLayout.setHorizontalGroup(
                formLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(formLayout.createSequentialGroup()
                                .addGap(50)
                                .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(maPhieuLabel)
                                        .addComponent(nhaCungCapLabel)
                                        .addComponent(nhanVienLabel))
                                .addGap(20)
                                .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(maPhieuField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nhaCungCapField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nhanVienField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGap(60)
                                .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(ngayNhapLabel)
                                        .addComponent(tongTienLabel))
                                .addGap(20)
                                .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ngayNhapField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tongTienField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                .addGap(50))
                        .addGroup(formLayout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(40)
                                .addComponent(changeButton)
                                .addGap(40)
                                .addComponent(deleteButton)
                                .addGap(40)
                                .addComponent(refreshButton))
        );

        formLayout.setVerticalGroup(
                formLayout.createSequentialGroup()
                        .addContainerGap(15, 15)
                        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(maPhieuLabel)
                                .addComponent(maPhieuField)
                                .addComponent(ngayNhapLabel)
                                .addComponent(ngayNhapField))
                        .addGap(10)
                        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nhaCungCapLabel)
                                .addComponent(nhaCungCapField)
                                .addComponent(tongTienLabel)
                                .addComponent(tongTienField))
                        .addGap(10)
                        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nhanVienLabel)
                                .addComponent(nhanVienField))
                        .addGap(15)
                        .addGroup(formLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addButton)
                                .addComponent(changeButton)
                                .addComponent(deleteButton)
                                .addComponent(refreshButton))
                        .addContainerGap(10, 10)
        );

        // === Layout cho thanh tìm kiếm ===
        GroupLayout searchLayout = new GroupLayout(searchBar);
        searchBar.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
                searchLayout.createSequentialGroup()
                        .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
                        .addComponent(searchLabel)
                        .addGap(10)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(searchButton)
                        .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
        );
        searchLayout.setVerticalGroup(
                searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(searchLabel)
                                .addComponent(searchField)
                                .addComponent(searchButton))
        );

        // === Layout chính của toàn panel ===
        GroupLayout mainLayout = new GroupLayout(this);
        this.setLayout(mainLayout);
        mainLayout.setAutoCreateGaps(true);
        mainLayout.setAutoCreateContainerGaps(true);

        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(PhieuNhapForm)
                        .addComponent(searchBar)
                        .addComponent(tableScrollPane)
        );

        mainLayout.setVerticalGroup(
                mainLayout.createSequentialGroup()
                        .addComponent(PhieuNhapForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchBar)
                        .addComponent(tableScrollPane)
        );
    }

    private void setStyle() {
        // Đường viền cho form nhập liệu
        PhieuNhapForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
                "Thông tin phiếu nhập", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        // Nút
        addButton.setText("Thêm");
        changeButton.setText("Sửa");
        deleteButton.setText("Xóa");
        refreshButton.setText("Làm mới");
        searchButton.setText("Tìm kiếm");

        Font fontButton = new Font("Arial", Font.BOLD, 14);
        addButton.setFont(fontButton);
        changeButton.setFont(fontButton);
        deleteButton.setFont(fontButton);
        refreshButton.setFont(fontButton);
        searchButton.setFont(fontButton);

        // Nhãn
        Font fontLabel = new Font("Arial", Font.BOLD, 16);
        maPhieuLabel.setFont(fontLabel);
        ngayNhapLabel.setFont(fontLabel);
        nhaCungCapLabel.setFont(fontLabel);
        nhanVienLabel.setFont(fontLabel);
        tongTienLabel.setFont(fontLabel);
        searchLabel.setFont(fontLabel);
    }
}
