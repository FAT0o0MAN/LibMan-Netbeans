package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DocGia extends JPanel {
    JPanel DocGiaForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable DocGiaJTable;
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


    public DocGia() {
        initGUI();
    }

    private void initGUI() {
        setStyle();

    
        String[] columnNames = { "ID", "Tên độc giả", "Địa chỉ", "Số điện thoại", "Giới tính"};
        Object[][] data = {
            { 1, "Doraemon", "Fujiko F. Fujio", "1", "1" },
            { 2, "Conan", "Aoyama Gosho", "1", "1", "1" },
            { 3, "Naruto", "Masashi Kishimoto", "1", "1" }
        };
        DocGiaJTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(DocGiaJTable);


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
