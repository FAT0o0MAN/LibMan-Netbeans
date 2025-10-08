package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class TacGia extends JPanel {
    JPanel TacGiaForm = new JPanel();
    JScrollPane tableScrollPane;
    JTable TacGiaJTable;
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


    public TacGia() {
        initGUI();
    }

    private void initGUI() {
        setStyle();

    
        String[] columnNames = { "ID", "Tên tác giả", "Năm sinh", "Quê quán"};
        Object[][] data = {
            { 1, "Doraemon", "Fujiko F. Fujio", "1" },
            { 2, "Conan", "Aoyama Gosho", "1", "1" },
            { 3, "Naruto", "Masashi Kishimoto", "1" }
        };
        TacGiaJTable = new JTable(data, columnNames);
        tableScrollPane = new JScrollPane(TacGiaJTable);


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
