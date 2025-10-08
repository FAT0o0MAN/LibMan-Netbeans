package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import BUS.SachBUS;
import DTO.SachDTO;
import javax.swing.table.DefaultTableModel;

public class Sach extends JPanel {
    JPanel SachForm = new JPanel();
    JPanel SachImg = new JPanel();
    JScrollPane tableScrollPane;
    JTable SachJTable;
    JPanel searchBar = new JPanel();

    JTextField tenField = new JTextField();
    JTextField namField = new JTextField();
    JTextField soluongField = new JTextField();
    JTextField searchField = new JTextField();
    
    JComboBox<String> maloaiCB = new JComboBox<>();
    JComboBox<String> tacgiaCB = new JComboBox<>();
    JComboBox<String> nhaxuatbanCB = new JComboBox<>();
    JComboBox<String> makeCB = new JComboBox<>();

    JButton imgButton = new JButton();
    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    JLabel tenLabel = new JLabel("Tên sách:");
    JLabel maloaiLabel = new JLabel("Mã loại:");
    JLabel tacgiaLabel = new JLabel("Tác giả:");
    JLabel nsxLabel = new JLabel("Nhà sản xuất:");
    JLabel hinhLabel = new JLabel("Hình ảnh:");
    JLabel namLabel = new JLabel("Năm xuất bản:");
    JLabel soluongLabel = new JLabel("Số lượng:");
    JLabel makeLabel = new JLabel("Mã kệ sách:");
    JLabel imgLabelHolder = new JLabel("Ảnh");
    JLabel searchLabel = new JLabel("Tìm kiếm:");

    SachBUS sachBUS = new SachBUS();

    DefaultTableModel model;


    public Sach() {
        initComponents();
        initGUI();
    }

    public void initComponents() {

        maloaiCB.addItem("1");
        maloaiCB.addItem("2");
        maloaiCB.addItem("3");
        tacgiaCB.addItem("1");
        tacgiaCB.addItem("2");
        tacgiaCB.addItem("3");
        nhaxuatbanCB.addItem("1");
        nhaxuatbanCB.addItem("2");
        nhaxuatbanCB.addItem("3");
        makeCB.addItem("1");
        makeCB.addItem("2");
        makeCB.addItem("3");


        String[] columnNames = { "ID", "Tên sách", "Mã tác giả", "Mã nhà sản xuất", "Loại sách", "Số lượng", "Năm xuất bản", "Mã kệ sách", "Ảnh"};
        Object[][] data = {
            { 1, "Doraemon", "Fujiko F. Fujio", "1", "1", "1", "1", "1", "1" },
            { 2, "Conan", "Aoyama Gosho", "1", "1", "1", "1", "1", "1" },
            { 3, "Naruto", "Masashi Kishimoto", "1", "1", "1", "1", "1", "1" }
        };
        model = new DefaultTableModel(data, columnNames);
        SachJTable = new JTable(model);
        tableScrollPane = new JScrollPane(SachJTable);


        addButton.addActionListener(e -> onAddSach());
        deleteButton.addActionListener(e -> onDeleteSach());
        searchButton.addActionListener(e -> onSearchSach());
        refreshButton.addActionListener(e -> refreshTable());


        SachJTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = SachJTable.getSelectedRow();
                if (row >= 0) {
                    tenField.setText(SachJTable.getValueAt(row, 1).toString());
                    tacgiaCB.setSelectedItem(SachJTable.getValueAt(row, 2).toString());
                    nhaxuatbanCB.setSelectedItem(SachJTable.getValueAt(row, 3).toString());
                    maloaiCB.setSelectedItem(SachJTable.getValueAt(row, 4).toString());
                    soluongField.setText(SachJTable.getValueAt(row, 5).toString());
                    namField.setText(SachJTable.getValueAt(row, 6).toString());
                    makeCB.setSelectedItem(SachJTable.getValueAt(row, 7).toString());
                }
            }
        });

    }

    private void initGUI() {
        setStyle();


        GroupLayout formGroupLayout = new GroupLayout(SachForm);
        SachForm.setLayout(formGroupLayout);  
        
        formGroupLayout.setHorizontalGroup(
            formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(formGroupLayout.createSequentialGroup()
                    .addGap(50, 100, Short.MAX_VALUE) 
                    .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(tenLabel)
                                .addComponent(maloaiLabel)
                                .addComponent(tacgiaLabel)
                                .addComponent(nsxLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tenField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(maloaiCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tacgiaCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nhaxuatbanCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 120)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(hinhLabel)
                                .addComponent(namLabel)
                                .addComponent(soluongLabel)
                                .addComponent(makeLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(imgButton)
                                .addComponent(namField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(soluongField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(makeCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addComponent(addButton)
                            .addGap(50)
                            .addComponent(changeButton)
                            .addGap(50)
                            .addComponent(deleteButton)
                            .addGap(50)
                            .addComponent(refreshButton))
                    )
                    .addGap(50, 100, Short.MAX_VALUE) // right margin
                )
        );
        formGroupLayout.setVerticalGroup(
            formGroupLayout.createSequentialGroup()
                .addContainerGap(15, 15)
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tenLabel).addComponent(tenField)
                    .addComponent(hinhLabel).addComponent(imgButton))
                .addGap(10)   
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(maloaiLabel).addComponent(maloaiCB)
                    .addComponent(namLabel).addComponent(namField))
                .addGap(10)  
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tacgiaLabel).addComponent(tacgiaCB)
                    .addComponent(soluongLabel).addComponent(soluongField))
                .addGap(10)    
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nsxLabel).addComponent(nhaxuatbanCB)
                    .addComponent(makeLabel).addComponent(makeCB))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(changeButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        );


        
        
        SachImg.add(imgLabelHolder, BorderLayout.CENTER);



        GroupLayout searchLayout = new GroupLayout(searchBar);
        searchBar.setLayout(searchLayout);

        searchLayout.setHorizontalGroup(
            searchLayout.createSequentialGroup()
                .addGap(0,  Short.MAX_VALUE, Short.MAX_VALUE) 
                .addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(10)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(searchButton)
                    )
                )
                .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE) 
        );
        searchLayout.setVerticalGroup(
            searchLayout.createSequentialGroup()
                .addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchField)
                    .addComponent(searchButton)
                )
        );


        GroupLayout mainGroupLayout = new GroupLayout(this);
        this.setLayout(mainGroupLayout);    
        mainGroupLayout.setAutoCreateGaps(true);
        mainGroupLayout.setAutoCreateContainerGaps(true);

        mainGroupLayout.setHorizontalGroup(
            mainGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(mainGroupLayout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(SachForm)
                    .addComponent(SachImg, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                    .addGap(50))
                .addGroup(mainGroupLayout.createSequentialGroup()
                    .addGap(50)
                    .addComponent(searchBar)
                    .addGap(50))
                .addComponent(tableScrollPane)
        );
        mainGroupLayout.setVerticalGroup(
            mainGroupLayout.createSequentialGroup()
                .addGroup(mainGroupLayout.createParallelGroup()
                    .addComponent(SachForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SachImg))
                .addComponent(searchBar)
                .addComponent(tableScrollPane)
        );
    }



    private void onAddSach() {
        try {
            SachDTO s = new SachDTO(
                "S" + (model.getRowCount() + 1),
                tenField.getText(),
                (String) maloaiCB.getSelectedItem(),
                (String) tacgiaCB.getSelectedItem(),
                (String) nhaxuatbanCB.getSelectedItem(),
                Integer.parseInt(namField.getText()),
                Integer.parseInt(soluongField.getText()),
                (String) makeCB.getSelectedItem(),
                "none.jpg"
            );

            sachBUS.addSach(s);
            model.addRow(s.toRow());
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + ex.getMessage());
        }
    }

    private void onDeleteSach() {
        int row = SachJTable.getSelectedRow();
        if (row >= 0) {
            String maSach = (String) model.getValueAt(row, 0);
            sachBUS.removeSach(maSach);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn sách cần xóa!");
        }
    }

    private void onSearchSach() {
        String keyword = searchField.getText();
        model.setRowCount(0);
        for (SachDTO s : sachBUS.searchByName(keyword)) {
            model.addRow(s.toRow());
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (SachDTO s : sachBUS.getAll()) {
            model.addRow(s.toRow());
        }
    }

    private void clearFields() {
        tenField.setText("");
        namField.setText("");
        soluongField.setText("");
        searchField.setText("");
    }



    public void setStyle() {
        
        //setBackground(Color.PINK);

        SachImg.setLayout(new BorderLayout());
        imgLabelHolder.setHorizontalAlignment(SwingConstants.CENTER);
        
        SachForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
        SachImg.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

        imgButton.setText("Chọn ảnh");
        addButton.setText("Thêm");
        changeButton.setText("Sửa");
        deleteButton.setText("Xóa");
        refreshButton.setText("Làm mới");
        searchButton.setText("Tìm");
        imgButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        changeButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
        imgLabelHolder.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));


        tenLabel.setFont(new Font("Arial", Font.BOLD, 16));
        maloaiLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tacgiaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nsxLabel.setFont(new Font("Arial", Font.BOLD, 16));
        hinhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        namLabel.setFont(new Font("Arial", Font.BOLD, 16));
        soluongLabel.setFont(new Font("Arial", Font.BOLD, 16));
        makeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));

    }

}
