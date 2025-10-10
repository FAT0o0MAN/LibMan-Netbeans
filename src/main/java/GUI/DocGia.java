package GUI;

import BUS.DocGiaBUS;
import DTO.DocGiaDTO;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DocGia extends JPanel {
    JPanel DocGiaForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable DocGiaJTable;
    DefaultTableModel model;
    JPanel searchBar = new JPanel();

    JTextField tenField = new JTextField();
    JTextField diachiField = new JTextField();
    JTextField sdtField = new JTextField();
    JTextField searchField = new JTextField();
    
    JComboBox<String> gioitinhCB = new JComboBox<>();
    
    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    JLabel tenLabel = new JLabel("Tên độc giả:");
    JLabel diachiLabel = new JLabel("Địa chỉ:");
    JLabel sdtLabel = new JLabel("Số điện thoại:");
    JLabel gioitinhLabel = new JLabel("Giới tính:");
    JLabel searchLabel = new JLabel("Tìm kiếm:");
    
    DocGiaBUS docgiaBUS = new DocGiaBUS();


    public DocGia() {
        initComponents();
        initGUI();
    }
    
    private void initComponents() {
        
        gioitinhCB.addItem("Nam");
        gioitinhCB.addItem("Nữ");
        
        
        String[] columnNames = { "ID", "Tên độc giả", "Địa chỉ", "Số điện thoại", "Giới tính"};
        Object[][] data = {};
        model = new DefaultTableModel(data, columnNames);
        DocGiaJTable = new JTable(model);
        tableScrollPane = new JScrollPane(DocGiaJTable);


        addButton.addActionListener(e -> onAddDocGia());
        deleteButton.addActionListener(e -> onDeleteDocGia());
        searchButton.addActionListener(e -> onSearchDocGia());
        refreshButton.addActionListener(e -> refreshTable());


        DocGiaJTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = DocGiaJTable.getSelectedRow();
                if (row >= 0) {
                    tenField.setText(DocGiaJTable.getValueAt(row, 1).toString());
                    diachiField.setText(DocGiaJTable.getValueAt(row, 2).toString());
                    sdtField.setText(DocGiaJTable.getValueAt(row, 3).toString());
                    gioitinhCB.setSelectedItem(DocGiaJTable.getValueAt(row, 4).toString());
                }
            }
        });
    }

    private void initGUI() {
        setStyle();



        GroupLayout formGroupLayout = new GroupLayout(DocGiaForm);
        DocGiaForm.setLayout(formGroupLayout);  
        
        formGroupLayout.setHorizontalGroup(
            formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(formGroupLayout.createSequentialGroup()
                    .addGap(50, 100, Short.MAX_VALUE) 
                    .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(tenLabel)
                                .addComponent(diachiLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tenField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(diachiField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 80, 120)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(sdtLabel)
                                .addComponent(gioitinhLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(sdtField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(gioitinhCB, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(sdtLabel).addComponent(sdtField))
                .addGap(40)   
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(diachiLabel).addComponent(diachiField)
                    .addComponent(gioitinhLabel).addComponent(gioitinhCB))
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(changeButton)
                    .addComponent(deleteButton)
                    .addComponent(refreshButton))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        );


        GroupLayout searchLayout = new GroupLayout(searchBar);
        searchBar.setLayout(searchLayout);

        searchLayout.setHorizontalGroup(
            searchLayout.createSequentialGroup()
                .addGap(0,  Short.MAX_VALUE, Short.MAX_VALUE)  // left flex gap
                .addGroup(searchLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(searchLayout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(10)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(searchButton)
                    )
                )
                .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)  // right flex gap
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
                    .addGap(100)
                    .addComponent(DocGiaForm)
                    .addGap(100))
                .addGroup(mainGroupLayout.createSequentialGroup()
                    .addGap(100)
                    .addComponent(searchBar)
                    .addGap(100))
                .addGroup(mainGroupLayout.createSequentialGroup()
                    .addGap(100)
                    .addComponent(tableScrollPane)
                    .addGap(100))
        );
        mainGroupLayout.setVerticalGroup(
            mainGroupLayout.createSequentialGroup()
                .addGroup(mainGroupLayout.createParallelGroup()
                    .addComponent(DocGiaForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(searchBar)
                .addComponent(tableScrollPane)
        );
    }
    
    
    
    
    private void onAddDocGia() {
        try {
            DocGiaDTO dg = new DocGiaDTO(
                "DG" + (model.getRowCount() + 1),
                tenField.getText(),
                diachiField.getText(),
                Integer.parseInt(sdtField.getText()),
                (String) gioitinhCB.getSelectedItem()
            );

            docgiaBUS.addDocGia(dg);
            model.addRow(dg.toRow());
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + ex.getMessage());
        }
    }

    private void onDeleteDocGia() {
        int row = DocGiaJTable.getSelectedRow();
        if (row >= 0) {
            String maDocGia = (String) model.getValueAt(row, 0);
            docgiaBUS.removeDocGia(maDocGia);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn độc giả cần xóa!");
        }
    }

    private void onSearchDocGia() {
        String keyword = searchField.getText();
        model.setRowCount(0);
        for (DocGiaDTO s : docgiaBUS.searchByName(keyword)) {
            model.addRow(s.toRow());
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (DocGiaDTO s : docgiaBUS.getAll()) {
            model.addRow(s.toRow());
        }
    }

    private void clearFields() {
        tenField.setText("");
        diachiField.setText("");
        sdtField.setText("");
        searchField.setText("");
    }


    public void setStyle() {
        
        //setBackground(Color.PINK);
        
        DocGiaForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

        addButton.setText("Thêm");
        changeButton.setText("Sửa");
        deleteButton.setText("Xóa");
        refreshButton.setText("Làm mới");
        searchButton.setText("Tìm");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        changeButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        refreshButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));


        tenLabel.setFont(new Font("Arial", Font.BOLD, 16));
        diachiLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sdtLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gioitinhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));

    }

}
