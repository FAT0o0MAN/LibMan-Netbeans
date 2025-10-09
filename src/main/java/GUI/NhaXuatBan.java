package GUI;

import BUS.NhaXuatBanBUS;
import DTO.NhaXuatBanDTO;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class NhaXuatBan extends JPanel {
    JPanel NhaXuatBanForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable NhaXuatBanJTable;
    DefaultTableModel model;
    JPanel searchBar = new JPanel();

    JTextField tenField = new JTextField();
    JTextField diachiField = new JTextField();
    JTextField sdtField = new JTextField();
    JTextField searchField = new JTextField();
    
    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    JLabel tenLabel = new JLabel("Tên tác giả:");
    JLabel sdtLabel = new JLabel("Số điện thoại:");
    JLabel diachiLabel = new JLabel("Địa chỉ:");
    JLabel searchLabel = new JLabel("Tìm kiếm:");
    
    NhaXuatBanBUS nhaxuatbanBUS = new NhaXuatBanBUS();

    public NhaXuatBan() {
        initComponents();
        initGUI();
    }
    
    private void initComponents() {
        
        String[] columnNames = { "ID", "Tên nhà xuất bản", "Số điện thoại", "Địa chỉ"};
        Object[][] data = {};
        model = new DefaultTableModel(data, columnNames);
        NhaXuatBanJTable = new JTable(model);
        tableScrollPane = new JScrollPane(NhaXuatBanJTable);


        addButton.addActionListener(e -> onAddNhaXuatBan());
        deleteButton.addActionListener(e -> onDeleteNhaXuatBan());
        searchButton.addActionListener(e -> onSearchNhaXuatBan());
        refreshButton.addActionListener(e -> refreshTable());


        NhaXuatBanJTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = NhaXuatBanJTable.getSelectedRow();
                if (row >= 0) {
                    tenField.setText(NhaXuatBanJTable.getValueAt(row, 1).toString());
                    sdtField.setText(NhaXuatBanJTable.getValueAt(row, 2).toString());
                    diachiField.setText(NhaXuatBanJTable.getValueAt(row, 3).toString());
                }
            }
        });
    }

    private void initGUI() {
        setStyle();


        GroupLayout formGroupLayout = new GroupLayout(NhaXuatBanForm);
        NhaXuatBanForm.setLayout(formGroupLayout);  
        
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
                                .addComponent(sdtLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(sdtField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addComponent(addButton)
                            .addGap(50)
                            .addComponent(changeButton)
                            .addGap(50)
                            .addComponent(deleteButton)
                            .addGap(50)
                            .addComponent(refreshButton))
                    )
                    .addGap(50, 100, Short.MAX_VALUE)
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
                    .addComponent(diachiLabel).addComponent(diachiField))
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
                    .addComponent(NhaXuatBanForm)
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
                    .addComponent(NhaXuatBanForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(searchBar)
                .addComponent(tableScrollPane)
        );
    }
    
    
    
    private void onAddNhaXuatBan() {
        try {
            NhaXuatBanDTO nxb = new NhaXuatBanDTO(
                "NXB" + (model.getRowCount() + 1),
                tenField.getText(),
                Integer.parseInt(sdtField.getText()),
                diachiField.getText()
            );

            nhaxuatbanBUS.addNhaXuatBan(nxb);
            model.addRow(nxb.toRow());
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + ex.getMessage());
        }
    }

    private void onDeleteNhaXuatBan() {
        int row = NhaXuatBanJTable.getSelectedRow();
        if (row >= 0) {
            String maNhaXuatBan = (String) model.getValueAt(row, 0);
            nhaxuatbanBUS.removeNhaXuatBan(maNhaXuatBan);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn nhà xuất bản cần xóa!");
        }
    }

    private void onSearchNhaXuatBan() {
        String keyword = searchField.getText();
        model.setRowCount(0);
        for (NhaXuatBanDTO s : nhaxuatbanBUS.searchByName(keyword)) {
            model.addRow(s.toRow());
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (NhaXuatBanDTO s : nhaxuatbanBUS.getAll()) {
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
        
        NhaXuatBanForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
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
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));

    }

}
