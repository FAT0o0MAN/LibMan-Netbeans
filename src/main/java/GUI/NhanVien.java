package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class NhanVien extends JPanel {
    JPanel NhanVienForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable NhanVienJTable;
    JPanel searchBar = new JPanel();

    JTextField tenField = new JTextField();
    JTextField namsinhField = new JTextField();
    JTextField sdtField = new JTextField();
    JTextField ngaybdField = new JTextField();
    JTextField luongField = new JTextField();
    JTextField diachiField = new JTextField();
    JTextField searchField = new JTextField();
    
    JComboBox<String> gioitinhCB = new JComboBox<>();

    JButton addButton = new JButton();
    JButton changeButton = new JButton();
    JButton deleteButton = new JButton();
    JButton refreshButton = new JButton();
    JButton searchButton = new JButton();

    JLabel tenLabel = new JLabel("Tên nhân viên:");
    JLabel namsinhLabel = new JLabel("Năm sinh:");
    JLabel sdtLabel = new JLabel("Số điện thoại:");
    JLabel gioitinhLabel = new JLabel("Giới tính:");
    JLabel ngaybdLabel = new JLabel("Ngày bắt đầu:");
    JLabel luongLabel = new JLabel("Lương:");
    JLabel diachiLabel = new JLabel("Địa chỉ:");
    JLabel searchLabel = new JLabel("Tìm kiếm:");


    public NhanVien() {
        initGUI();
        
    }
    

    private void initGUI() {
        setStyle();

    
        String[] columnNames = { "ID", "Tên nhân viên", "Giới tính", "Năm sinh", "Số điện thoại", "Ngày bắt đầu", "Lương", "Địa chỉ"};
        Object[][] data = {
            { 1, "Doraemon", "Fujiko F. Fujio", "1", "1", "1", "1", "1" },
            { 2, "Conan", "Aoyama Gosho", "1", "1", "1", "1", "1" },
            { 3, "Naruto", "Masashi Kishimoto", "1", "1", "1", "1", "1" }
        };
        NhanVienJTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(NhanVienJTable);


        GroupLayout formGroupLayout = new GroupLayout(NhanVienForm);
        NhanVienForm.setLayout(formGroupLayout);  
        
        formGroupLayout.setHorizontalGroup(
            formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(formGroupLayout.createSequentialGroup()
                    .addGap(50, 100, Short.MAX_VALUE) 
                    .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(formGroupLayout.createSequentialGroup()
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(tenLabel)
                                .addComponent(sdtLabel)
                                .addComponent(diachiLabel)
                                .addComponent(namsinhLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tenField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sdtField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(diachiField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(namsinhField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 120)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(ngaybdLabel)
                                .addComponent(luongLabel)
                                .addComponent(gioitinhLabel))
                            .addGap(20)
                            .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(ngaybdField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addComponent(luongField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(ngaybdLabel).addComponent(ngaybdField))
                .addGap(10)   
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sdtLabel).addComponent(sdtField)
                    .addComponent(luongLabel).addComponent(luongField))
                .addGap(10)  
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(diachiLabel).addComponent(diachiField)
                    .addComponent(gioitinhLabel).addComponent(gioitinhCB))
                .addGap(10)    
                .addGroup(formGroupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(namsinhLabel).addComponent(namsinhField))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(NhanVienForm)
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
                    .addComponent(NhanVienForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(searchBar)
                .addComponent(tableScrollPane)
        );
    }


    public void setStyle() {
        
        //setBackground(Color.PINK);
        
        NhanVienForm.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
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
        namsinhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sdtLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gioitinhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        ngaybdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        luongLabel.setFont(new Font("Arial", Font.BOLD, 16));
        diachiLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));

    }

}
