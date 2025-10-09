package GUI;

import BUS.TacGiaBUS;
import DTO.TacGiaDTO;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TacGia extends JPanel {
    JPanel TacGiaForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable TacGiaJTable;
    DefaultTableModel model;
    JPanel searchBar = new JPanel();

    JTextField tenField = new JTextField();
    JTextField quequanField = new JTextField();
    JTextField namsinhField = new JTextField();
    JTextField searchField = new JTextField();
    
    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    JLabel tenLabel = new JLabel("Tên tác giả:");
    JLabel quequanLabel = new JLabel("Quê quán:");
    JLabel namsinhLabel = new JLabel("Năm sinh:");
    JLabel searchLabel = new JLabel("Tìm kiếm:");
    
    TacGiaBUS tacgiaBUS = new TacGiaBUS();


    public TacGia() {
        initComponents();
        initGUI();
    }
    
    
    private void initComponents() {
        
        String[] columnNames = { "ID", "Tên tác giả", "Năm sinh", "Quê quán"};
        Object[][] data = {};
        model = new DefaultTableModel(data, columnNames);
        TacGiaJTable = new JTable(model);
        tableScrollPane = new JScrollPane(TacGiaJTable);


        addButton.addActionListener(e -> onAddTacGia());
        deleteButton.addActionListener(e -> onDeleteTacGia());
        searchButton.addActionListener(e -> onSearchTacGia());
        refreshButton.addActionListener(e -> refreshTable());


        TacGiaJTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = TacGiaJTable.getSelectedRow();
                if (row >= 0) {
                    tenField.setText(TacGiaJTable.getValueAt(row, 1).toString());
                    namsinhField.setText(TacGiaJTable.getValueAt(row, 2).toString());
                    quequanField.setText(TacGiaJTable.getValueAt(row, 3).toString());
                }
            }
        });
    }

    private void initGUI() {
        setStyle();


        GroupLayout formGroupLayout = new GroupLayout(TacGiaForm);
        TacGiaForm.setLayout(formGroupLayout);  
        
        formGroupLayout.setHorizontalGroup(
            formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(formGroupLayout.createSequentialGroup()
                    .addGap(50, 100, Short.MAX_VALUE) 
                    .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(tenLabel)
                                .addComponent(quequanLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tenField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(quequanField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 80, 120)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(namsinhLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(namsinhField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(namsinhLabel).addComponent(namsinhField))
                .addGap(40)   
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(quequanLabel).addComponent(quequanField))
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
                    .addComponent(TacGiaForm)
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
                    .addComponent(TacGiaForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(searchBar)
                .addComponent(tableScrollPane)
        );
    }
    
    
    
    
    private void onAddTacGia() {
        try {
            TacGiaDTO tg = new TacGiaDTO(
                "TG" + (model.getRowCount() + 1),
                tenField.getText(),
                Integer.parseInt(namsinhField.getText()),
                quequanField.getText()
            );
       
            tacgiaBUS.addTacGia(tg);
            model.addRow(tg.toRow());
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi nhập liệu: " + ex.getMessage());
        }
    }

    private void onDeleteTacGia() {
        int row = TacGiaJTable.getSelectedRow();
        if (row >= 0) {
            String maTacGia = (String) model.getValueAt(row, 0);
            tacgiaBUS.removeTacGia(maTacGia);
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Chọn tác giả cần xóa!");
        }
    }

    private void onSearchTacGia() {
        String keyword = searchField.getText();
        model.setRowCount(0);
        for (TacGiaDTO s : tacgiaBUS.searchByName(keyword)) {
            model.addRow(s.toRow());
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (TacGiaDTO s : tacgiaBUS.getAll()) {
            model.addRow(s.toRow());
        }
    }

    private void clearFields() {
        tenField.setText("");
        namsinhField.setText("");
        quequanField.setText("");
        searchField.setText("");
    }


    public void setStyle() {
        
        //setBackground(Color.PINK);
        
        TacGiaForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
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
        quequanLabel.setFont(new Font("Arial", Font.BOLD, 16));
        namsinhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));

    }

}
